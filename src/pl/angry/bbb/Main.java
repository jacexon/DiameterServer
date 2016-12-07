package pl.angry.bbb;

import dk.i1.diameter.*;
import dk.i1.diameter.node.*;


/**
 * A simple Credit-control server that accepts and grants everything
 */
class cc_test_server extends NodeManager {
    cc_test_server(NodeSettings node_settings) {
        super(node_settings);
    }


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
        ds.addAAServer(host_id,realm,port);
    }


}
