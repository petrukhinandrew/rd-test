using System.Reflection;
using JetBrains.Collections.Viewable;
using JetBrains.Lifetimes;
using JetBrains.Rd;
using JetBrains.Rd.Impl;
using JetBrains.Rider.Model;
using Timer = System.Timers.Timer;

namespace dotnet_side;

public static class Program
{
    public static void Main()
    {
        var ldef = new LifetimeDefinition();
        var lifetime = ldef.Lifetime;
        SingleThreadScheduler.RunInCurrentStackframe(lifetime, "Client", scheduler =>
        {
            var wire = new SocketWire.Client(lifetime, scheduler, 8083, "Client");
            var idKind = IdKind.Client;
            var serializers = new Serializers();
            var protocol = new Protocol("client side", serializers, new Identities(idKind), scheduler, wire,
                lifetime);


            var ilModel = new IlModel(lifetime, protocol);
            var asmReq = ilModel.GetIlSigModel().AsmRequest;
            var asmResp = ilModel.GetIlSigModel().AsmResponse;

            asmReq.Advise(lifetime, req =>
            {
                Console.WriteLine($"required asm is at {req.RootAsm}");
                Console.WriteLine("Immitating work");
                Thread.Sleep(2000);
                Console.WriteLine("Firing asm");
                asmResp.Fire(new IlAsmDto(1, req.RootAsm, [
                    new IlTypeDto(2, "2", [new IlFieldDto(5, "5", 2, 2), new IlFieldDto(6, "6", 2, 3)]),
                    new IlTypeDto(3, "3", [new IlFieldDto(7, "7", 3, 2)]),
                    new IlTypeDto(4, "4", [new IlFieldDto(8, "8", 4, 2), new IlFieldDto(9, "9", 4, 3)]),
                ]));
                Console.WriteLine("Fired asm");
            });
        });
    }
}
