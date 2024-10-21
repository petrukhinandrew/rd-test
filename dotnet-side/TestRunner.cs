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
            // var model = new PrimitiveModel(lifetime, protocol);
            // var setInt = model.SetIntValue;
            // setInt.Fire(1);
            // var setStr = model.SetStrValue;
            // setStr.Fire("hello");
            // setInt.Fire(2);
            // setStr.Fire("world");

            // var model = new PrimitiveClassModel(lifetime, protocol);
            // var structSignal = model.SetStruct;
            // var simpleStruct = new SimpleStruct("123", 1);
            // structSignal.Fire(simpleStruct);
            // var structListSignal = model.MultipleStruct;
            // var anotherSimpleStruct = new SimpleStruct("456", 2);
            // structListSignal.Fire([simpleStruct, anotherSimpleStruct]);
            // structSignal.Fire(anotherSimpleStruct);

            // var model = new LinksModel(lifetime, protocol);
            // var childA1 = new ChildA("child A1");
            // var childA2 = new ChildA("child A2");
            // var childB = new ChildB(1);
            // var parent1 = new ParentInst(childA1, childB);
            // var parent2 = new ParentInst(childA2, childB);
            // model.ParentInsts.Fire([parent1, parent2]);
            // var storage = new InstStorage([parent1, parent2], [childA1, childA2], [childB]);
            // model.InstStorage.Fire([storage]);

            var ilModel = new IlModel(lifetime, protocol);
            var asmReq = ilModel.GetIlSigModel().AsmRequest;
            var asmResp = ilModel.GetIlSigModel().AsmResponse;

            asmReq.Advise(lifetime, req =>
            {
                Console.WriteLine($"required asm is at {req.RootAsm}");
                Console.WriteLine("Immitating work");
                Thread.Sleep(500);
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
