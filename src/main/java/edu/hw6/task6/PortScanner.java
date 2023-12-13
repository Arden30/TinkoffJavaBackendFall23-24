package edu.hw6.task6;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.util.Map;

public class PortScanner {

    private static final Map<Integer, String> PORTS = Map.of(
        135, "EPMAP",
        137, "Служба имен NetBIOS",
        138, "Служба датаграмм NetBIOS",
        139, "Служба сеансов NetBIOS",
        445, "Microsoft-DS Active Directory",
        843, "Adobe Flash",
        1900, "Simple Service Discovery Protocol (SSDP)",
        3702, "Динамическое обнаружение веб-служб",
        17500, "Dropbox",
        27017, "MongoDB"
    );

    private static final int MAX_PORT = 49151;

    public String infoAboutUsedPorts() {
        StringBuilder res = new StringBuilder("Протокол   Порт   Сервис\n");
        for (int port = 0; port < MAX_PORT; port++) {
            if (scanTCP(port)) {
                if (PORTS.containsKey(port)) {
                    String str = String.format("TCP %10d    %s\n", port, PORTS.get(port));
                    res.append(str);
                }
            } else if (scanUDP(port)) {
                if (PORTS.containsKey(port)) {
                    String str = String.format("UDP %10d    %s\n", port, PORTS.get(port));
                    res.append(str);
                }
            }
        }

        return res.toString();
    }

    private boolean scanTCP(int port) {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    private boolean scanUDP(int port) {
        try (DatagramSocket datagramSocket = new DatagramSocket(port)) {
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}
