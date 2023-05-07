package eduhejband.io;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

//@Configuration
//@Profile("development")
@Development
public class MinhaConfiguration {


    // @Bean(name = "aplicationName")
    // public String aplicationName(){
        //return "Sistemas de vendas";
     // }

    //@Bean(name = "aplicationSecond")
     //public String aplicationSecond(){
        //return "Sistemas de Compras";
    //}

    @Bean
    public CommandLineRunner executar(){
        return args -> {
            System.out.println("Rodando outra configuracao");
        };
    }
}




