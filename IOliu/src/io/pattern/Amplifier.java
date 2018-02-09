package io.pattern;

public class Amplifier {
	private Voice voice;

	public Amplifier(Voice voice) {
		super();
		this.voice = voice;
	}

	public Amplifier() {
		super();
	}
	
	
	
	public void say(){
		System.out.println(voice.getVoice()*10000);
	}
}
