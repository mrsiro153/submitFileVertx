package client;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpClientOptions;
import io.vertx.core.http.HttpClientRequest;

/**
 * Created by huydoan on 08/07/2017.
 */
public class ClientSubmitfile extends AbstractVerticle {
    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        HttpClientRequest req = vertx.createHttpClient(new HttpClientOptions()).post(8081, "localhost", "/hello", resp -> {
            System.out.println("Response " + resp.statusCode());
            resp.bodyHandler(body->{
                System.out.println(body.toString());
            });
        });
        req.sendHead();

        /*String filename = "upload.txt";
        FileSystem fs = vertx.fileSystem();

        fs.props(filename, ares -> {
            FileProps props = ares.result();
            System.out.println("props is " + props);
            long size = props.size();
            req.headers().set("content-length", "" + size);
            fs.open(filename, new OpenOptions(), ares2 -> {
                AsyncFile file = ares2.result();
                Pump pump = Pump.pump(file, req);
                file.endHandler(v -> {
                    req.end();
                });
                pump.start();
            });
        });*/


    }
}
