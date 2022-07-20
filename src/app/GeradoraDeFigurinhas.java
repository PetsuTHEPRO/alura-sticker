package app;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class GeradoraDeFigurinhas {

	public void cria(InputStream inputStream, String nomeArquivo) throws Exception {
	
		// leitura da imagem
		//InputStream inputStream = new FileInputStream(new File("entrada/Filme.jpg"));
		//InputStream inputStream = new URL("https://imersao-java-apis.s3.amazonaws.com/TopMovies_6.jpg").openStream();
		BufferedImage imagemOriginal = ImageIO.read(inputStream);
		
		// cria nova imagem em memória com transparência e com tamanho novo
		int largura = imagemOriginal.getWidth();
		int altura = imagemOriginal.getHeight();
		int novaAltura = altura + 400;
		
		BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);
		
		// copia a imagem original pra novo imagem(em memória)
		Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
		graphics.drawImage(imagemOriginal, 0, 0, null);
		
		// configurando a fonte
		
		var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 200);
		graphics.setColor(Color.BLUE);
		graphics.setFont(fonte);

		// escreve uma frase na nova imagem
		
		graphics.drawString("Imersão Alura", 355, novaAltura - 125);
		
		// escreve a nova imagem em um arquivo
		ImageIO.write(novaImagem, "png", new File(nomeArquivo));
	}
	
}
