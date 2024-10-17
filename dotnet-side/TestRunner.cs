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
            var protocol = new Protocol("client side", new Serializers(), new Identities(idKind), scheduler, wire,
                lifetime);
            var model = new DemoModel(lifetime, protocol);
            var signal = model.GetExtModel().Checker;
            signal.Advise(lifetime, _ =>
            {
                Console.WriteLine("got checker notify\r\n" + model);
                Thread.Sleep(TimeSpan.FromSeconds(2));
                signal.Fire();
            });
        });
    }
}
