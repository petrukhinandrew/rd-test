//------------------------------------------------------------------------------
// <auto-generated>
//     This code was generated by a RdGen v1.12.
//
//     Changes to this file may cause incorrect behavior and will be lost if
//     the code is regenerated.
// </auto-generated>
//------------------------------------------------------------------------------
using System;
using System.Linq;
using System.Collections.Generic;
using System.Runtime.InteropServices;
using JetBrains.Annotations;

using JetBrains.Core;
using JetBrains.Diagnostics;
using JetBrains.Collections;
using JetBrains.Collections.Viewable;
using JetBrains.Lifetimes;
using JetBrains.Serialization;
using JetBrains.Rd;
using JetBrains.Rd.Base;
using JetBrains.Rd.Impl;
using JetBrains.Rd.Tasks;
using JetBrains.Rd.Util;
using JetBrains.Rd.Text;


// ReSharper disable RedundantEmptyObjectCreationArgumentList
// ReSharper disable InconsistentNaming
// ReSharper disable RedundantOverflowCheckingContext


namespace JetBrains.Rider.Model
{
  
  
  /// <summary>
  /// <p>Generated from: Model.kt:52</p>
  /// </summary>
  public class LinksModel : RdExtBase
  {
    //fields
    //public fields
    [NotNull] public ISignal<List<ParentInst>> ParentInsts => _ParentInsts;
    [NotNull] public ISignal<List<JetBrains.Rider.Model.InstStorage>> InstStorage => _InstStorage;
    
    //private fields
    [NotNull] private readonly RdSignal<List<ParentInst>> _ParentInsts;
    [NotNull] private readonly RdSignal<List<JetBrains.Rider.Model.InstStorage>> _InstStorage;
    
    //primary constructor
    private LinksModel(
      [NotNull] RdSignal<List<ParentInst>> parentInsts,
      [NotNull] RdSignal<List<JetBrains.Rider.Model.InstStorage>> instStorage
    )
    {
      if (parentInsts == null) throw new ArgumentNullException("parentInsts");
      if (instStorage == null) throw new ArgumentNullException("instStorage");
      
      _ParentInsts = parentInsts;
      _InstStorage = instStorage;
      BindableChildren.Add(new KeyValuePair<string, object>("parentInsts", _ParentInsts));
      BindableChildren.Add(new KeyValuePair<string, object>("instStorage", _InstStorage));
    }
    //secondary constructor
    private LinksModel (
    ) : this (
      new RdSignal<List<ParentInst>>(ReadParentInstList, WriteParentInstList),
      new RdSignal<List<JetBrains.Rider.Model.InstStorage>>(ReadInstStorageList, WriteInstStorageList)
    ) {}
    //deconstruct trait
    //statics
    
    public static CtxReadDelegate<List<ParentInst>> ReadParentInstList = ParentInst.Read.List();
    public static CtxReadDelegate<List<JetBrains.Rider.Model.InstStorage>> ReadInstStorageList = JetBrains.Rider.Model.InstStorage.Read.List();
    
    public static  CtxWriteDelegate<List<ParentInst>> WriteParentInstList = ParentInst.Write.List();
    public static  CtxWriteDelegate<List<JetBrains.Rider.Model.InstStorage>> WriteInstStorageList = JetBrains.Rider.Model.InstStorage.Write.List();
    
    protected override long SerializationHash => 3319301644439084295L;
    
    protected override Action<ISerializers> Register => RegisterDeclaredTypesSerializers;
    public static void RegisterDeclaredTypesSerializers(ISerializers serializers)
    {
      
      serializers.RegisterToplevelOnce(typeof(DemoRoot), DemoRoot.RegisterDeclaredTypesSerializers);
    }
    
    public LinksModel(Lifetime lifetime, IProtocol protocol) : this()
    {
      Identify(protocol.Identities, RdId.Root.Mix("LinksModel"));
      this.BindTopLevel(lifetime, protocol, "LinksModel");
    }
    
    //constants
    
    //custom body
    //methods
    //equals trait
    //hash code trait
    //pretty print
    public override void Print(PrettyPrinter printer)
    {
      printer.Println("LinksModel (");
      using (printer.IndentCookie()) {
        printer.Print("parentInsts = "); _ParentInsts.PrintEx(printer); printer.Println();
        printer.Print("instStorage = "); _InstStorage.PrintEx(printer); printer.Println();
      }
      printer.Print(")");
    }
    //toString
    public override string ToString()
    {
      var printer = new SingleLinePrettyPrinter();
      Print(printer);
      return printer.ToString();
    }
  }
  
  
  /// <summary>
  /// <p>Generated from: Model.kt:57</p>
  /// </summary>
  public sealed class ChildA : IPrintable, IEquatable<ChildA>
  {
    //fields
    //public fields
    [NotNull] public string Name {get; private set;}
    
    //private fields
    //primary constructor
    public ChildA(
      [NotNull] string name
    )
    {
      if (name == null) throw new ArgumentNullException("name");
      
      Name = name;
    }
    //secondary constructor
    //deconstruct trait
    public void Deconstruct([NotNull] out string name)
    {
      name = Name;
    }
    //statics
    
    public static CtxReadDelegate<ChildA> Read = (ctx, reader) => 
    {
      var name = reader.ReadString();
      var _result = new ChildA(name);
      return _result;
    };
    
    public static CtxWriteDelegate<ChildA> Write = (ctx, writer, value) => 
    {
      writer.Write(value.Name);
    };
    
    //constants
    
    //custom body
    //methods
    //equals trait
    public override bool Equals(object obj)
    {
      if (ReferenceEquals(null, obj)) return false;
      if (ReferenceEquals(this, obj)) return true;
      if (obj.GetType() != GetType()) return false;
      return Equals((ChildA) obj);
    }
    public bool Equals(ChildA other)
    {
      if (ReferenceEquals(null, other)) return false;
      if (ReferenceEquals(this, other)) return true;
      return Name == other.Name;
    }
    //hash code trait
    public override int GetHashCode()
    {
      unchecked {
        var hash = 0;
        hash = hash * 31 + Name.GetHashCode();
        return hash;
      }
    }
    //pretty print
    public void Print(PrettyPrinter printer)
    {
      printer.Println("ChildA (");
      using (printer.IndentCookie()) {
        printer.Print("name = "); Name.PrintEx(printer); printer.Println();
      }
      printer.Print(")");
    }
    //toString
    public override string ToString()
    {
      var printer = new SingleLinePrettyPrinter();
      Print(printer);
      return printer.ToString();
    }
  }
  
  
  /// <summary>
  /// <p>Generated from: Model.kt:60</p>
  /// </summary>
  public sealed class ChildB : IPrintable, IEquatable<ChildB>
  {
    //fields
    //public fields
    public int Id {get; private set;}
    
    //private fields
    //primary constructor
    public ChildB(
      int id
    )
    {
      Id = id;
    }
    //secondary constructor
    //deconstruct trait
    public void Deconstruct(out int id)
    {
      id = Id;
    }
    //statics
    
    public static CtxReadDelegate<ChildB> Read = (ctx, reader) => 
    {
      var id = reader.ReadInt();
      var _result = new ChildB(id);
      return _result;
    };
    
    public static CtxWriteDelegate<ChildB> Write = (ctx, writer, value) => 
    {
      writer.Write(value.Id);
    };
    
    //constants
    
    //custom body
    //methods
    //equals trait
    public override bool Equals(object obj)
    {
      if (ReferenceEquals(null, obj)) return false;
      if (ReferenceEquals(this, obj)) return true;
      if (obj.GetType() != GetType()) return false;
      return Equals((ChildB) obj);
    }
    public bool Equals(ChildB other)
    {
      if (ReferenceEquals(null, other)) return false;
      if (ReferenceEquals(this, other)) return true;
      return Id == other.Id;
    }
    //hash code trait
    public override int GetHashCode()
    {
      unchecked {
        var hash = 0;
        hash = hash * 31 + Id.GetHashCode();
        return hash;
      }
    }
    //pretty print
    public void Print(PrettyPrinter printer)
    {
      printer.Println("ChildB (");
      using (printer.IndentCookie()) {
        printer.Print("id = "); Id.PrintEx(printer); printer.Println();
      }
      printer.Print(")");
    }
    //toString
    public override string ToString()
    {
      var printer = new SingleLinePrettyPrinter();
      Print(printer);
      return printer.ToString();
    }
  }
  
  
  /// <summary>
  /// <p>Generated from: Model.kt:63</p>
  /// </summary>
  public sealed class InstStorage : IPrintable, IEquatable<InstStorage>
  {
    //fields
    //public fields
    [NotNull] public List<ParentInst> ParentInsts {get; private set;}
    [NotNull] public List<ChildA> ChildrenA {get; private set;}
    [NotNull] public List<ChildB> ChildrenB {get; private set;}
    
    //private fields
    //primary constructor
    public InstStorage(
      [NotNull] List<ParentInst> parentInsts,
      [NotNull] List<ChildA> childrenA,
      [NotNull] List<ChildB> childrenB
    )
    {
      if (parentInsts == null) throw new ArgumentNullException("parentInsts");
      if (childrenA == null) throw new ArgumentNullException("childrenA");
      if (childrenB == null) throw new ArgumentNullException("childrenB");
      
      ParentInsts = parentInsts;
      ChildrenA = childrenA;
      ChildrenB = childrenB;
    }
    //secondary constructor
    //deconstruct trait
    public void Deconstruct([NotNull] out List<ParentInst> parentInsts, [NotNull] out List<ChildA> childrenA, [NotNull] out List<ChildB> childrenB)
    {
      parentInsts = ParentInsts;
      childrenA = ChildrenA;
      childrenB = ChildrenB;
    }
    //statics
    
    public static CtxReadDelegate<InstStorage> Read = (ctx, reader) => 
    {
      var parentInsts = ReadParentInstList(ctx, reader);
      var childrenA = ReadChildAList(ctx, reader);
      var childrenB = ReadChildBList(ctx, reader);
      var _result = new InstStorage(parentInsts, childrenA, childrenB);
      return _result;
    };
    public static CtxReadDelegate<List<ParentInst>> ReadParentInstList = ParentInst.Read.List();
    public static CtxReadDelegate<List<ChildA>> ReadChildAList = ChildA.Read.List();
    public static CtxReadDelegate<List<ChildB>> ReadChildBList = ChildB.Read.List();
    
    public static CtxWriteDelegate<InstStorage> Write = (ctx, writer, value) => 
    {
      WriteParentInstList(ctx, writer, value.ParentInsts);
      WriteChildAList(ctx, writer, value.ChildrenA);
      WriteChildBList(ctx, writer, value.ChildrenB);
    };
    public static  CtxWriteDelegate<List<ParentInst>> WriteParentInstList = ParentInst.Write.List();
    public static  CtxWriteDelegate<List<ChildA>> WriteChildAList = ChildA.Write.List();
    public static  CtxWriteDelegate<List<ChildB>> WriteChildBList = ChildB.Write.List();
    
    //constants
    
    //custom body
    //methods
    //equals trait
    public override bool Equals(object obj)
    {
      if (ReferenceEquals(null, obj)) return false;
      if (ReferenceEquals(this, obj)) return true;
      if (obj.GetType() != GetType()) return false;
      return Equals((InstStorage) obj);
    }
    public bool Equals(InstStorage other)
    {
      if (ReferenceEquals(null, other)) return false;
      if (ReferenceEquals(this, other)) return true;
      return ParentInsts.SequenceEqual(other.ParentInsts) && ChildrenA.SequenceEqual(other.ChildrenA) && ChildrenB.SequenceEqual(other.ChildrenB);
    }
    //hash code trait
    public override int GetHashCode()
    {
      unchecked {
        var hash = 0;
        hash = hash * 31 + ParentInsts.ContentHashCode();
        hash = hash * 31 + ChildrenA.ContentHashCode();
        hash = hash * 31 + ChildrenB.ContentHashCode();
        return hash;
      }
    }
    //pretty print
    public void Print(PrettyPrinter printer)
    {
      printer.Println("InstStorage (");
      using (printer.IndentCookie()) {
        printer.Print("parentInsts = "); ParentInsts.PrintEx(printer); printer.Println();
        printer.Print("childrenA = "); ChildrenA.PrintEx(printer); printer.Println();
        printer.Print("childrenB = "); ChildrenB.PrintEx(printer); printer.Println();
      }
      printer.Print(")");
    }
    //toString
    public override string ToString()
    {
      var printer = new SingleLinePrettyPrinter();
      Print(printer);
      return printer.ToString();
    }
  }
  
  
  /// <summary>
  /// <p>Generated from: Model.kt:53</p>
  /// </summary>
  public sealed class ParentInst : IPrintable, IEquatable<ParentInst>
  {
    //fields
    //public fields
    [NotNull] public JetBrains.Rider.Model.ChildA ChildA {get; private set;}
    [NotNull] public JetBrains.Rider.Model.ChildB ChildB {get; private set;}
    
    //private fields
    //primary constructor
    public ParentInst(
      [NotNull] JetBrains.Rider.Model.ChildA childA,
      [NotNull] JetBrains.Rider.Model.ChildB childB
    )
    {
      if (childA == null) throw new ArgumentNullException("childA");
      if (childB == null) throw new ArgumentNullException("childB");
      
      ChildA = childA;
      ChildB = childB;
    }
    //secondary constructor
    //deconstruct trait
    public void Deconstruct([NotNull] out JetBrains.Rider.Model.ChildA childA, [NotNull] out JetBrains.Rider.Model.ChildB childB)
    {
      childA = ChildA;
      childB = ChildB;
    }
    //statics
    
    public static CtxReadDelegate<ParentInst> Read = (ctx, reader) => 
    {
      var childA = JetBrains.Rider.Model.ChildA.Read(ctx, reader);
      var childB = JetBrains.Rider.Model.ChildB.Read(ctx, reader);
      var _result = new ParentInst(childA, childB);
      return _result;
    };
    
    public static CtxWriteDelegate<ParentInst> Write = (ctx, writer, value) => 
    {
      JetBrains.Rider.Model.ChildA.Write(ctx, writer, value.ChildA);
      JetBrains.Rider.Model.ChildB.Write(ctx, writer, value.ChildB);
    };
    
    //constants
    
    //custom body
    //methods
    //equals trait
    public override bool Equals(object obj)
    {
      if (ReferenceEquals(null, obj)) return false;
      if (ReferenceEquals(this, obj)) return true;
      if (obj.GetType() != GetType()) return false;
      return Equals((ParentInst) obj);
    }
    public bool Equals(ParentInst other)
    {
      if (ReferenceEquals(null, other)) return false;
      if (ReferenceEquals(this, other)) return true;
      return Equals(ChildA, other.ChildA) && Equals(ChildB, other.ChildB);
    }
    //hash code trait
    public override int GetHashCode()
    {
      unchecked {
        var hash = 0;
        hash = hash * 31 + ChildA.GetHashCode();
        hash = hash * 31 + ChildB.GetHashCode();
        return hash;
      }
    }
    //pretty print
    public void Print(PrettyPrinter printer)
    {
      printer.Println("ParentInst (");
      using (printer.IndentCookie()) {
        printer.Print("childA = "); ChildA.PrintEx(printer); printer.Println();
        printer.Print("childB = "); ChildB.PrintEx(printer); printer.Println();
      }
      printer.Print(")");
    }
    //toString
    public override string ToString()
    {
      var printer = new SingleLinePrettyPrinter();
      Print(printer);
      return printer.ToString();
    }
  }
}
