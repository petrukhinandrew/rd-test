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
  /// <p>Generated from: Model.kt:231</p>
  /// </summary>
  public class ExtModel : RdExtBase
  {
    //fields
    //public fields
    [NotNull] public ISignal<Unit> Checker => _Checker;
    
    //private fields
    [NotNull] private readonly RdSignal<Unit> _Checker;
    
    //primary constructor
    private ExtModel(
      [NotNull] RdSignal<Unit> checker
    )
    {
      if (checker == null) throw new ArgumentNullException("checker");
      
      _Checker = checker;
      BindableChildren.Add(new KeyValuePair<string, object>("checker", _Checker));
    }
    //secondary constructor
    internal ExtModel (
    ) : this (
      new RdSignal<Unit>(JetBrains.Rd.Impl.Serializers.ReadVoid, JetBrains.Rd.Impl.Serializers.WriteVoid)
    ) {}
    //deconstruct trait
    //statics
    
    
    
    protected override long SerializationHash => 2364843396187734L;
    
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
      printer.Println("ExtModel (");
      using (printer.IndentCookie()) {
        printer.Print("checker = "); _Checker.PrintEx(printer); printer.Println();
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
  public static class DemoModelExtModelEx
   {
    public static ExtModel GetExtModel(this DemoModel demoModel)
    {
      return demoModel.GetOrCreateExtension("extModel", () => new ExtModel());
    }
  }
}
