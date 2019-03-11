package ru.roman.certification.jcl;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Collections;
import java.util.Enumeration;

import static java.lang.System.out;

/**
 *
 */
public class ListNetworkInterfaces {
    public static void main(String args[]) throws SocketException {
        Enumeration<NetworkInterface> nets = NetworkInterface.getNetworkInterfaces();

        for (NetworkInterface netIf : Collections.list(nets)) {

            out.printf("Display name: %s\n", netIf.getDisplayName());
            out.printf("Name: %s\n", netIf.getName());

            Enumeration<NetworkInterface> subIfs = netIf.getSubInterfaces();
            for (NetworkInterface subIf : Collections.list(subIfs)) {

                out.printf("\tSub Interface Display name: %s\n", subIf.getDisplayName());
                out.printf("\tSub Interface Name: %s\n", subIf.getName());

            }
            out.println();
        }
    }
}
