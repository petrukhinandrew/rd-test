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
            var model = new LinksModel(lifetime, protocol);
            var childA1 = new ChildA("child A1");
            var childA2 = new ChildA("child A2");
            var childB = new ChildB(1);
            var parent1 = new ParentInst(childA1, childB);
            var parent2 = new ParentInst(childA2, childB);
            model.ParentInsts.Fire([parent1, parent2]);
            var storage = new InstStorage([parent1, parent2], [childA1, childA2], [childB]);
            model.InstStorage.Fire([storage]);
        });
    }
}
