package pl.angry.bbb;

import dk.i1.diameter.*;
import dk.i1.diameter.node.*;

import java.io.IOException;


/**
 * A simple Credit-control server that accepts and grants everything
 */
class Server {

    //Kamil
    public static final void main(String args[]) throws Exception {
        if(args.length<2) {
            System.out.println("Usage: <host-id> <realm> [<port>]");
            return;
        }

        String host_id = args[0];
        String realm = args[1];
        int port;
        if(args.length>=3)
            port = Integer.parseInt(args[2]);
        else
            port = 3868;

        DiameterServer ds = new DiameterServer();
        DiameterAAServer aaServer = ds.addAAServer(host_id,realm,port);
        aaServer.addUser("user@example.pl", "aaa", "assdasfffsaf");
        aaServer.setClusterAddress("224.0.0.1");

        System.out.println("Hit enter to terminate server");

        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }

        aaServer.stop(50); //Stop but allow 50ms graceful shutdown
    }


}
