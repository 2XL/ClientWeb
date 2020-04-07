package others;

//GetHttp.java
//
//This program uses a socket to connects to a Web server (port #80) 
//It uses the HTTP protocol directly with the GET command
//then proceeds to copy everything returned until the socket connection is
//closed.
//
//This example is adapted _Java Examples in a Nutshell_. (http://www.oreilly.com)
//Copyright (c) 1997 by David Flanagan

import java.io.*;
import java.net.*;

public class GetHttp 
{
public static void main(String[] args) {
try {
  
  URL url = new URL("http://deim.urv.cat/~josepm.banus/miniwebxdd/xdd.html");

  String protocol = url.getProtocol();  //  "http"
  String host     = url.getHost();      //  "www.iro.umontreal.ca"
  String filename = url.getFile();      //  "~vaucher/test.html"
  int port        = url.getPort();      //  -1
  if (url.getPort() == -1) port = 80;   // if no port, use the default HTTP port
  
  // Open a network socket connection to the specified host and port
  //    and open PrintWriter and inputStream on connection
  
  Socket socket = new Socket(host, port);
  InputStream from_server = socket.getInputStream();
  PrintWriter to_server = 
    new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
  
  // Send the HTTP GET command to the Web server, specifying the file.
  
  to_server.print("GET " + filename + "\r\n\r\n");
  to_server.flush();  // Send it right now!
  
  // Now read the server's response, and write it to the printer
  
  byte[] buffer = new byte[4096];
  int    bytes_read;
  String text = "" ;   // Un StringBuffer serait mieux !!
  
  while((bytes_read = from_server.read(buffer)) != -1) {
    System.out.write(buffer, 0, bytes_read);
    text = text + new String(buffer, 0, bytes_read);
  }
  System.out.println("\n===========================================\n" +
                    text );
  
  socket.close();
}
catch (Exception e) {    // Report any errors that arise
  System.err.println(e);
  System.err.println("Usage: java HttpClient1");
}
}
}