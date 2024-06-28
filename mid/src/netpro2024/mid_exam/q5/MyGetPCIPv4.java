package netpro2024.mid_exam.q5;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class MyGetPCIPv4 {

    public static void main(String[] args) {
        try {
                // ここにコードを記載する
                InetAddress addr = InetAddress.getByName();
                System.out.println(addr.getHostAddress());
        } catch (UnknownHostException e) {
            System.out.println("Error");
        }
    }
}