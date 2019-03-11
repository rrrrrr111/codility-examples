package ru.roman.certification.jcl;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Arrays;
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
            printAddresses(netIf);
            printProps(netIf);

            Enumeration<NetworkInterface> subIfs = netIf.getSubInterfaces();
            for (NetworkInterface subIf : Collections.list(subIfs)) {

                out.printf("\tSub Interface Display name: %s\n", subIf.getDisplayName());
                out.printf("\tSub Interface Name: %s\n", subIf.getName());
                printAddresses(subIf);
                printProps(subIf);
            }
            out.println();
        }
    }

    private static void printAddresses(NetworkInterface netIf) {
        Enumeration<InetAddress> inetAddresses = netIf.getInetAddresses();
        for (InetAddress inetAddress : Collections.list(inetAddresses)) {
            out.printf("InetAddress: %s\n", inetAddress);
        }
    }

    private static void printProps(NetworkInterface netint) throws SocketException {
        out.printf("Up? %s\n", netint.isUp());
        out.printf("Loopback? %s\n", netint.isLoopback());
        out.printf("PointToPoint? %s\n", netint.isPointToPoint());
        out.printf("Supports multicast? %s\n", netint.supportsMulticast());
        out.printf("Virtual? %s\n", netint.isVirtual());
        out.printf("Hardware address: %s\n", Arrays.toString(netint.getHardwareAddress()));
        out.printf("MTU: %s\n", netint.getMTU());
    }
}
