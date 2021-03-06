package br.edu.fema.spaceman.control;

import org.cocos2d.layers.CCLayer;
import org.cocos2d.types.CGPoint;

import br.edu.fema.spaceman.configuracao.Assets;
import br.edu.fema.spaceman.delegate.ButtonDelegate;
import static br.edu.fema.spaceman.configuracao.Aparelho.*;

public class Controle extends CCLayer implements ButtonDelegate {

	private Botao direito;
	private Botao esquerdo;
	private Botao atirar;

	public Controle() {
		setIsTouchEnabled(true);
		
		//Instanciamento dos botoes
		direito = new Botao(Assets.RIGHT);
		esquerdo = new Botao(Assets.LEFT);
		atirar = new Botao(Assets.SHOOT);
		
		//Parametrização do delegate
		direito.setDelegate(this);
		esquerdo.setDelegate(this);
		atirar.setDelegate(this);
		
		//posicionar
		
		posicionarBotoes();
		
		//adiciona os botoes na tela
		addChild(esquerdo);
		addChild(direito);
		addChild(atirar);
	}

	public static Controle getControles() {
		return new Controle();
	}
	
	private void posicionarBotoes(){
		esquerdo.setPosition(screenResolution(CGPoint.ccp(40, 40)));
		direito.setPosition(screenResolution(CGPoint.ccp(100, 40)));
		atirar.setPosition(screenResolution(CGPoint.ccp(screenWidth()-40, 40)));
	}

	@Override
	public void buttonClicked(Botao sender) {
		if(sender.equals(atirar)){
			System.out.println("Atirar tocado!");
		} else if(sender.equals(direito)){
			System.out.println("Direito pressionado!");
		} else if(sender.equals(esquerdo)){
			System.out.println("Esquerdo pressionado!");
		}
	}

}
