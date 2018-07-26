package controllers;

import models.Rabbit;
import play.api.templates.Html;
import play.data.DynamicForm;
import play.data.Form;
import play.mvc.*;

import models.addproduct;
import scala.Int;
import scala.math.Ordering;
import views.html.*;

import javax.persistence.criteria.From;


public class Application extends Controller {

    public static Result Main(Html Content) {
        return ok(Main.render(Content));
    }

    public static Result index() {
        return Main(Contents.render());
    }

    public static Result Promotion() {
        return Main(promotion.render());
    }

    public static Result Product() {
        return Main(product.render());
    }

    public static Result Rabbit() {
        Rabbit MiniRex = new Rabbit("R001", "minirex", 3000.00, 10);
        Rabbit Netherland_Dwarf = new Rabbit("R002", "netherland dwarf", 4000.00, 11);
        Rabbit Holland_Lop = new Rabbit("R003", "holland lop", 5000.00, 8);
        Rabbit Satin_Angora = new Rabbit("R004", "satin angora", 4000.00, 11);
        Rabbit Dutch = new Rabbit("R005", "Dutch", 2000.00, 9);
        Rabbit New_Zealand = new Rabbit("R006", "new zealand", 6000.00, 7);
        {
            return Main(views.html.Rabbits.render(MiniRex,Netherland_Dwarf,Holland_Lop,Satin_Angora,Dutch,New_Zealand));
        }
    }
    public static Result inputproduct(){

        return Main(from.render());
    }

    public static Result showproduct(){
        DynamicForm input = Form.form().bindFromRequest();
         String id,name;
         double price;
         int amount;

         id=input.get("id");
        name=input.get("brand");
        price=Double.parseDouble(input.get("price"));
        amount=Integer.parseInt(input.get("amount"));

        addproduct output=new addproduct(id,name,price,amount);
        return Main(showform.render(output));
    }
}

