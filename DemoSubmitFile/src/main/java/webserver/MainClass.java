package webserver;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.BodyHandler;

/**
 * Created by huydoan on 08/07/2017.
 */
public class MainClass extends AbstractVerticle{
    //
    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        HttpServer server = vertx.createHttpServer();
        //
        Router router = Router.router(vertx);
        router.route().handler(BodyHandler.create());
        //
        router.get("/hello").handler(routingContext -> {
            HttpServerResponse response = routingContext.response();
            response
                    .putHeader("content-type", "text/html")
                    .end("<h1>Hello from my first Vert.x 3 application</h1>");
        });
        router.post("/hello").handler(routingContext -> {
            HttpServerResponse response = routingContext.response();
            response
                    .putHeader("content-type", "text/html")
                    .end("<h1>Hello from my first Vert.x 3 application POST</h1>");
        });
        server.requestHandler(router::accept)
                .listen(8081,result->{
                   if(result.succeeded()){
                       System.out.println("start vertx success");
                   }else {
                       System.out.println("Start vertx failed");
                   }
                });

    }
}
