import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        String host = "localhost";
        int port = 8989;
        try (Socket clientSocket = new Socket(host, port);

             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

            System.out.println(in.readLine());

            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите название, дату и потраченную сумму через пробел");
            String[] req = scanner.nextLine().split(" ");
            Request request = new Request(req[0], req[1], Integer.parseInt(req[2]));
            //Request request = new Request("булка", "2022.02.02", 100);

            ObjectMapper mapper = new ObjectMapper();
            out.println(mapper.writeValueAsString(request));

            Statistic stat = mapper.readValue(in.readLine(), Statistic.class);
            System.out.println(stat.toString());

        }
    }
}
