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
using System.Diagnostics.CodeAnalysis;
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
  /// <p>Generated from: Model.kt:21</p>
  /// </summary>
  public class IlModel : RdExtBase
  {
    //fields
    //public fields

    //private fields
    //primary constructor
    private IlModel(
    )
    {
    }
    //secondary constructor
    //deconstruct trait
    //statics



    protected override long SerializationHash => 6447058661582492715L;

    protected override Action<ISerializers> Register => RegisterDeclaredTypesSerializers;
    public static void RegisterDeclaredTypesSerializers(ISerializers serializers)
    {

      serializers.RegisterToplevelOnce(typeof(DemoRoot), DemoRoot.RegisterDeclaredTypesSerializers);
    }

    public IlModel(Lifetime lifetime, IProtocol protocol) : this()
    {
      Identify(protocol.Identities, RdId.Root.Mix("IlModel"));
      this.BindTopLevel(lifetime, protocol, "IlModel");
    }

    //constants

    //custom body
    //methods
    //equals trait
    //hash code trait
    //pretty print
    public override void Print(PrettyPrinter printer)
    {
      printer.Println("IlModel (");
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
  /// <p>Generated from: Model.kt:22</p>
  /// </summary>
  public sealed class IlAsmDto : IPrintable, IEquatable<IlAsmDto>
  {
    //fields
    //public fields
    public int Id {get; private set;}
    [NotNull] public string Path {get; private set;}
    [NotNull] public List<IlTypeDto> Types {get; private set;}

    //private fields
    //primary constructor
    public IlAsmDto(
      int id,
      [NotNull] string path,
      [NotNull] List<IlTypeDto> types
    )
    {
      if (path == null) throw new ArgumentNullException("path");
      if (types == null) throw new ArgumentNullException("types");

      Id = id;
      Path = path;
      Types = types;
    }
    //secondary constructor
    //deconstruct trait
    public void Deconstruct(out int id, [NotNull] out string path, [NotNull] out List<IlTypeDto> types)
    {
      id = Id;
      path = Path;
      types = Types;
    }
    //statics

    public static CtxReadDelegate<IlAsmDto> Read = (ctx, reader) =>
    {
      var id = reader.ReadInt();
      var path = reader.ReadString();
      var types = ReadIlTypeDtoList(ctx, reader);
      var _result = new IlAsmDto(id, path, types);
      return _result;
    };
    public static CtxReadDelegate<List<IlTypeDto>> ReadIlTypeDtoList = IlTypeDto.Read.List();

    public static CtxWriteDelegate<IlAsmDto> Write = (ctx, writer, value) =>
    {
      writer.Write(value.Id);
      writer.Write(value.Path);
      WriteIlTypeDtoList(ctx, writer, value.Types);
    };
    public static  CtxWriteDelegate<List<IlTypeDto>> WriteIlTypeDtoList = IlTypeDto.Write.List();

    //constants

    //custom body
    //methods
    //equals trait
    public override bool Equals(object obj)
    {
      if (ReferenceEquals(null, obj)) return false;
      if (ReferenceEquals(this, obj)) return true;
      if (obj.GetType() != GetType()) return false;
      return Equals((IlAsmDto) obj);
    }
    public bool Equals(IlAsmDto other)
    {
      if (ReferenceEquals(null, other)) return false;
      if (ReferenceEquals(this, other)) return true;
      return Id == other.Id && Path == other.Path && Types.SequenceEqual(other.Types);
    }
    //hash code trait
    public override int GetHashCode()
    {
      unchecked {
        var hash = 0;
        hash = hash * 31 + Id.GetHashCode();
        hash = hash * 31 + Path.GetHashCode();
        hash = hash * 31 + Types.ContentHashCode();
        return hash;
      }
    }
    //pretty print
    public void Print(PrettyPrinter printer)
    {
      printer.Println("IlAsmDto (");
      using (printer.IndentCookie()) {
        printer.Print("id = "); Id.PrintEx(printer); printer.Println();
        printer.Print("path = "); Path.PrintEx(printer); printer.Println();
        printer.Print("types = "); Types.PrintEx(printer); printer.Println();
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
  /// <p>Generated from: Model.kt:32</p>
  /// </summary>
  public sealed class IlFieldDto : IPrintable, IEquatable<IlFieldDto>
  {
    //fields
    //public fields
    public int Id {get; private set;}
    [NotNull] public string Name {get; private set;}
    public int DeclTypeId {get; private set;}
    public int FieldTypeId {get; private set;}

    //private fields
    //primary constructor
    public IlFieldDto(
      int id,
      [NotNull] string name,
      int declTypeId,
      int fieldTypeId
    )
    {
      if (name == null) throw new ArgumentNullException("name");

      Id = id;
      Name = name;
      DeclTypeId = declTypeId;
      FieldTypeId = fieldTypeId;
    }
    //secondary constructor
    //deconstruct trait
    public void Deconstruct(out int id, [NotNull] out string name, out int declTypeId, out int fieldTypeId)
    {
      id = Id;
      name = Name;
      declTypeId = DeclTypeId;
      fieldTypeId = FieldTypeId;
    }
    //statics

    public static CtxReadDelegate<IlFieldDto> Read = (ctx, reader) =>
    {
      var id = reader.ReadInt();
      var name = reader.ReadString();
      var declTypeId = reader.ReadInt();
      var fieldTypeId = reader.ReadInt();
      var _result = new IlFieldDto(id, name, declTypeId, fieldTypeId);
      return _result;
    };

    public static CtxWriteDelegate<IlFieldDto> Write = (ctx, writer, value) =>
    {
      writer.Write(value.Id);
      writer.Write(value.Name);
      writer.Write(value.DeclTypeId);
      writer.Write(value.FieldTypeId);
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
      return Equals((IlFieldDto) obj);
    }
    public bool Equals(IlFieldDto other)
    {
      if (ReferenceEquals(null, other)) return false;
      if (ReferenceEquals(this, other)) return true;
      return Id == other.Id && Name == other.Name && DeclTypeId == other.DeclTypeId && FieldTypeId == other.FieldTypeId;
    }
    //hash code trait
    public override int GetHashCode()
    {
      unchecked {
        var hash = 0;
        hash = hash * 31 + Id.GetHashCode();
        hash = hash * 31 + Name.GetHashCode();
        hash = hash * 31 + DeclTypeId.GetHashCode();
        hash = hash * 31 + FieldTypeId.GetHashCode();
        return hash;
      }
    }
    //pretty print
    public void Print(PrettyPrinter printer)
    {
      printer.Println("IlFieldDto (");
      using (printer.IndentCookie()) {
        printer.Print("id = "); Id.PrintEx(printer); printer.Println();
        printer.Print("name = "); Name.PrintEx(printer); printer.Println();
        printer.Print("declTypeId = "); DeclTypeId.PrintEx(printer); printer.Println();
        printer.Print("fieldTypeId = "); FieldTypeId.PrintEx(printer); printer.Println();
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
  /// <p>Generated from: Model.kt:27</p>
  /// </summary>
  public sealed class IlTypeDto : IPrintable, IEquatable<IlTypeDto>
  {
    //fields
    //public fields
    public int Id {get; private set;}
    [NotNull] public string Name {get; private set;}
    [NotNull] public List<IlFieldDto> Fields {get; private set;}

    //private fields
    //primary constructor
    public IlTypeDto(
      int id,
      [NotNull] string name,
      [NotNull] List<IlFieldDto> fields
    )
    {
      if (name == null) throw new ArgumentNullException("name");
      if (fields == null) throw new ArgumentNullException("fields");

      Id = id;
      Name = name;
      Fields = fields;
    }
    //secondary constructor
    //deconstruct trait
    public void Deconstruct(out int id, [NotNull] out string name, [NotNull] out List<IlFieldDto> fields)
    {
      id = Id;
      name = Name;
      fields = Fields;
    }
    //statics

    public static CtxReadDelegate<IlTypeDto> Read = (ctx, reader) =>
    {
      var id = reader.ReadInt();
      var name = reader.ReadString();
      var fields = ReadIlFieldDtoList(ctx, reader);
      var _result = new IlTypeDto(id, name, fields);
      return _result;
    };
    public static CtxReadDelegate<List<IlFieldDto>> ReadIlFieldDtoList = IlFieldDto.Read.List();

    public static CtxWriteDelegate<IlTypeDto> Write = (ctx, writer, value) =>
    {
      writer.Write(value.Id);
      writer.Write(value.Name);
      WriteIlFieldDtoList(ctx, writer, value.Fields);
    };
    public static  CtxWriteDelegate<List<IlFieldDto>> WriteIlFieldDtoList = IlFieldDto.Write.List();

    //constants

    //custom body
    //methods
    //equals trait
    public override bool Equals(object obj)
    {
      if (ReferenceEquals(null, obj)) return false;
      if (ReferenceEquals(this, obj)) return true;
      if (obj.GetType() != GetType()) return false;
      return Equals((IlTypeDto) obj);
    }
    public bool Equals(IlTypeDto other)
    {
      if (ReferenceEquals(null, other)) return false;
      if (ReferenceEquals(this, other)) return true;
      return Id == other.Id && Name == other.Name && Fields.SequenceEqual(other.Fields);
    }
    //hash code trait
    public override int GetHashCode()
    {
      unchecked {
        var hash = 0;
        hash = hash * 31 + Id.GetHashCode();
        hash = hash * 31 + Name.GetHashCode();
        hash = hash * 31 + Fields.ContentHashCode();
        return hash;
      }
    }
    //pretty print
    public void Print(PrettyPrinter printer)
    {
      printer.Println("IlTypeDto (");
      using (printer.IndentCookie()) {
        printer.Print("id = "); Id.PrintEx(printer); printer.Println();
        printer.Print("name = "); Name.PrintEx(printer); printer.Println();
        printer.Print("fields = "); Fields.PrintEx(printer); printer.Println();
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
