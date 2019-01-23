/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.roman.samples.jndi;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Hashtable;

/**
 * @author העמ
 */
public class Lookup {

    public static void main(String[] args) throws NamingException {
        Hashtable env = new Hashtable();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.fscontext.RefFSContextFactory");

        Context ctx = new InitialContext(env);
    }
}
