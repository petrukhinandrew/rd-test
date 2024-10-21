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
  /// <p>Generated from: Model.kt:203</p>
  /// </summary>
  public class ClassExtModel : RdExtBase
  {
    //fields
    //public fields
    [NotNull] public ISignal<int> Values => _Values;
    
    //private fields
    [NotNull] private readonly RdSignal<int> _Values;
    
    //primary constructor
    private ClassExtModel(
      [NotNull] RdSignal<int> values
    )
    {
      if (values == null) throw new ArgumentNullException("values");
      
      _Values = values;
      BindableChildren.Add(new KeyValuePair<string, object>("values", _Values));
    }
    //secondary constructor
    internal ClassExtModel (
    ) : this (
      new RdSignal<int>(JetBrains.Rd.Impl.Serializers.ReadInt, JetBrains.Rd.Impl.Serializers.WriteInt)
    ) {}
    //deconstruct trait
    //statics
    
    
    
    protected override long SerializationHash => 9039760352823104056L;
    
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
      printer.Println("ClassExtModel (");
      using (printer.IndentCookie()) {
        printer.Print("values = "); _Values.PrintEx(printer); printer.Println();
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
  public static class ClassWithExtClassExtModelEx
   {
    public static ClassExtModel GetClassExtModel(this ClassWithExt classWithExt)
    {
      return classWithExt.GetOrCreateExtension("classExtModel", () => new ClassExtModel());
    }
  }
}
