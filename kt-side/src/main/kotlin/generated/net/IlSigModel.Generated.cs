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
  /// <p>Generated from: Model.kt:40</p>
  /// </summary>
  public class IlSigModel : RdExtBase
  {
    //fields
    //public fields
    [NotNull] public ISignal<Request> AsmRequest => _AsmRequest;
    [NotNull] public ISignal<IlAsmDto> AsmResponse => _AsmResponse;
    
    //private fields
    [NotNull] private readonly RdSignal<Request> _AsmRequest;
    [NotNull] private readonly RdSignal<IlAsmDto> _AsmResponse;
    
    //primary constructor
    private IlSigModel(
      [NotNull] RdSignal<Request> asmRequest,
      [NotNull] RdSignal<IlAsmDto> asmResponse
    )
    {
      if (asmRequest == null) throw new ArgumentNullException("asmRequest");
      if (asmResponse == null) throw new ArgumentNullException("asmResponse");
      
      _AsmRequest = asmRequest;
      _AsmResponse = asmResponse;
      _AsmRequest.Async = true;
      _AsmResponse.Async = true;
      BindableChildren.Add(new KeyValuePair<string, object>("asmRequest", _AsmRequest));
      BindableChildren.Add(new KeyValuePair<string, object>("asmResponse", _AsmResponse));
    }
    //secondary constructor
    internal IlSigModel (
    ) : this (
      new RdSignal<Request>(Request.Read, Request.Write),
      new RdSignal<IlAsmDto>(IlAsmDto.Read, IlAsmDto.Write)
    ) {}
    //deconstruct trait
    //statics
    
    
    
    protected override long SerializationHash => -231705078597361284L;
    
    protected override Action<ISerializers> Register => RegisterDeclaredTypesSerializers;
    public static void RegisterDeclaredTypesSerializers(ISerializers serializers)
    {
      
      serializers.RegisterToplevelOnce(typeof(DemoRoot), DemoRoot.RegisterDeclaredTypesSerializers);
    }
    
    
    //constants
    
    //custom body
    //methods
    //equals trait
    //hash code trait
    //pretty print
    public override void Print(PrettyPrinter printer)
    {
      printer.Println("IlSigModel (");
      using (printer.IndentCookie()) {
        printer.Print("asmRequest = "); _AsmRequest.PrintEx(printer); printer.Println();
        printer.Print("asmResponse = "); _AsmResponse.PrintEx(printer); printer.Println();
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
  public static class IlModelIlSigModelEx
   {
    public static IlSigModel GetIlSigModel(this IlModel ilModel)
    {
      return ilModel.GetOrCreateExtension("ilSigModel", () => new IlSigModel());
    }
  }
  
  
  /// <summary>
  /// <p>Generated from: Model.kt:41</p>
  /// </summary>
  public sealed class Request : IPrintable, IEquatable<Request>
  {
    //fields
    //public fields
    [NotNull] public string RootAsm {get; private set;}
    
    //private fields
    //primary constructor
    public Request(
      [NotNull] string rootAsm
    )
    {
      if (rootAsm == null) throw new ArgumentNullException("rootAsm");
      
      RootAsm = rootAsm;
    }
    //secondary constructor
    //deconstruct trait
    public void Deconstruct([NotNull] out string rootAsm)
    {
      rootAsm = RootAsm;
    }
    //statics
    
    public static CtxReadDelegate<Request> Read = (ctx, reader) => 
    {
      var rootAsm = reader.ReadString();
      var _result = new Request(rootAsm);
      return _result;
    };
    
    public static CtxWriteDelegate<Request> Write = (ctx, writer, value) => 
    {
      writer.Write(value.RootAsm);
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
      return Equals((Request) obj);
    }
    public bool Equals(Request other)
    {
      if (ReferenceEquals(null, other)) return false;
      if (ReferenceEquals(this, other)) return true;
      return RootAsm == other.RootAsm;
    }
    //hash code trait
    public override int GetHashCode()
    {
      unchecked {
        var hash = 0;
        hash = hash * 31 + RootAsm.GetHashCode();
        return hash;
      }
    }
    //pretty print
    public void Print(PrettyPrinter printer)
    {
      printer.Println("Request (");
      using (printer.IndentCookie()) {
        printer.Print("rootAsm = "); RootAsm.PrintEx(printer); printer.Println();
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
