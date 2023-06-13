package org.java.demo;


import org.java.demo.pojo.Categoria;
import org.java.demo.pojo.Foto;
import org.java.demo.service.CatService;
import org.java.demo.service.FotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringIlMioFotoalbumApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringIlMioFotoalbumApplication.class, args);
	}
	
	@Autowired
	private FotoService fotoService;
	
	@Autowired
	private CatService catService;

	@Override
	public void run(String... args) throws Exception {
		
		Foto f1 = new Foto("cani", "foto cani labrador", "https://www.tuttogreen.it/wp-content/uploads/2019/03/shutterstock_1212827962.jpg", true, null);
		Foto f2 = new Foto("gatto", "foto gatto bianco", "https://blog.ferplast.com/wp-content/uploads/2022/11/beautiful-white-cat-with-blue-eyes-2022-11-16-02-05-37-utc-1024x683.jpg", true, null);
		Foto f3 = new Foto("montagne", "foto monte baldo", "https://t0.gstatic.com/licensed-image?q=tbn:ANd9GcR0bd0xgVQBLV9yB4RQZmdB1NHtxA6_OXZkm5XCmoqQ54yBDU3aXGCaCnyJjyv4BPqa", true, null);
		Foto f4 = new Foto("mare", "foto mare sardegna", "https://www.nieddittas.it/wp-content/uploads/2021/12/qual-e-il-mare-piu-bello-della-sardegna.jpg", true, null);
		Foto f5 = new Foto("colline", "foto colline verdi", "https://www.lucagino.it/wp-content/uploads/2017/11/Morbide-colline-crete-senesi-gregge-pecore-pascolo-luce-radente.jpg", true, null);
		Foto f6 = new Foto("luci", "foto luci rosse", "https://res.cloudinary.com/hello-tickets/image/upload/c_limit,f_auto,q_auto,w_768/v1622657308/post_images/amsterdam-127/jonathan-taylor-eZFPc1yp7qk-unsplash_Cropped.jpg", true, null);
		Foto f7 = new Foto("cannolo", "cannolo al cioccolato", "https://cdn.shopify.com/s/files/1/0383/4537/5788/products/CannoloalCioccolato_52e3083d-8a80-4959-a494-17e312683a58_1200x1200.jpg?v=1617045524", true, null);
		
		fotoService.save(f1);
		fotoService.save(f2);
		fotoService.save(f3);
		fotoService.save(f4);
		fotoService.save(f5);
		fotoService.save(f6);
		fotoService.save(f7);
		
		Categoria c1 = new Categoria("foto natura");
		Categoria c2 = new Categoria("foto animali");
		Categoria c3 = new Categoria("foto cibo");
		Categoria c4 = new Categoria("altro");
		
		catService.save(c1);
		catService.save(c2);
		catService.save(c3);
		catService.save(c4);
	}

}
