package ru.roman.certification.util;

//import bsh.EvalError;
//import bsh.Interpreter;

import org.apache.commons.lang3.ArrayUtils;

import java.util.IllegalFormatException;

/**
 * @author Roman 28.10.09 22:41
 */
public class ReplUtil {


    public static int counter;

    /**
     * oper - new Oper(){public Object e(){return ...;}}
     */
    public final static void evaluate(String eval, Object... arg) {
        if (arg == null) {
            arg = new Object[0];
        }
        counter++;
        String pattern = counter + ". ";
        try {
            int controlParamsCount = 0;
            if (eval != null) {
                pattern += "Evaluation %s => %s  ";
                //Interpreter bsh = new Interpreter();
                //Object result = bsh.eval(eval);
                arg = ArrayUtils.add(arg, 0, eval);
                //arg = ArrayUtils.add(arg, 1, result);
                controlParamsCount = 2;
            }
            if (arg.length > controlParamsCount) {
                pattern += "[Params to console : ";
                for (int i = controlParamsCount; i < arg.length; i++) {
                    pattern += "%s, ";
                }
                pattern = pattern.substring(0, pattern.length() - 2) + "]";
            }
            System.out.printf(pattern + "%n", arg);
        } catch (IllegalFormatException fe) {
            System.err.println("Pattern : " + pattern);
            fe.printStackTrace();
            //} catch (bsh.TargetError e) {
            //Throwable ex = e.getTarget();
            //  System.out.printf(counter + ". Evaluation " + eval + " => : Exception %s %s%n", ex.getClass().getName(), ex.getMessage());
            //} catch (EvalError evalError) {
            //  evalError.printStackTrace();
        }
    }
}
