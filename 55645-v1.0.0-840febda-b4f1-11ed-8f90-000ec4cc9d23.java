/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE563_Unused_Variable__unused_init_variable_String_06.java
Label Definition File: CWE563_Unused_Variable__unused_init_variable.label.xml
Template File: source-sinks-06.tmpl.java
*/
/*
* @description
* CWE: 563 Unused Variable
* BadSource:  Initialize data
* Sinks:
*    GoodSink: Use data
*    BadSink : do nothing
* Flow Variant: 06 Control flow: if(private_final_five==5) and if(private_final_five!=5)
*
* */

package testcases.CWE563_Unused_Variable;

import testcasesupport.*;

import javax.servlet.http.*;

public class CWE563_Unused_Variable__unused_init_variable_String_06 extends AbstractTestCase
{

    /* The variable below is declared "final", so a tool should be able
       to identify that reads of this will always give its initialized
       value. */
    private final int private_final_five = 5;

    public void bad() throws Throwable
    {
        String data;

        /* POTENTIAL FLAW: Initialize, but do not use data */
        data = "Good";

        if (private_final_five==5)
        {
            /* POTENTIAL FLAW: Do not use the variable */
            /* do nothing */
            ; /* empty statement needed for some flow variants */
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* FIX: Use data */
            IO.writeLine(data);

        }
    }

    /* goodB2G1() - use badsource and goodsink by changing private_final_five==5 to private_final_five!=5 */
    private void goodB2G1() throws Throwable
    {
        String data;

        /* POTENTIAL FLAW: Initialize, but do not use data */
        data = "Good";

        if(private_final_five!=5)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            /* POTENTIAL FLAW: Do not use the variable */
            /* do nothing */
            ; /* empty statement needed for some flow variants */
        }
        else {

            /* FIX: Use data */
            IO.writeLine(data);

        }
    }

    /* goodB2G2() - use badsource and goodsink by reversing statements in if  */
    private void goodB2G2() throws Throwable
    {
        String data;

        /* POTENTIAL FLAW: Initialize, but do not use data */
        data = "Good";

        if(private_final_five==5)
        {
            /* FIX: Use data */
            IO.writeLine(data);
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* POTENTIAL FLAW: Do not use the variable */
            /* do nothing */
            ; /* empty statement needed for some flow variants */

        }
    }

    public void good() throws Throwable
    {
        goodB2G1();
        goodB2G2();
    }

    /* Below is the main(). It is only used when building this testcase on
       its own for testing or for building a binary to use in testing binary
       analysis tools. It is not used when compiling all the testcases as one
       application, which is how source code analysis tools are tested. */
    public static void main(String[] args) throws ClassNotFoundException,
           InstantiationException, IllegalAccessException
    {
        mainFromParent(args);
    }
}
