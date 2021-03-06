
public class Part2 {
	public String findSimpleGene(String dna, String startCodon, String stopCodon){
		String newdna = dna.toUpperCase();
		int startIndex = newdna.indexOf(startCodon);
		
		if(startIndex == -1){
			return "gg";
		}
		int stopIndex = newdna.indexOf(stopCodon);
		if(stopIndex == -1){
			return "gg2";
		}
		
		if ((startIndex - stopIndex) % 3 == 0){
			String udna = newdna.substring(startIndex,stopIndex+3);
			String ldna = udna.toLowerCase();
			if(newdna == dna){
				return udna;
			}else{
				return ldna;
			}
			
		}
		return null;
	}
	public void testSimpleGene(){
		String dna = "BDEATGTAA";
		String dna2 = "AtgtAA";
		String dna3 = "BDEATGTA";
		String dna4 = "BEDATGATAA";
		System.out.println(findSimpleGene(dna,"ATG","TAA"));
		System.out.println(findSimpleGene(dna2,"ATG","TAA"));
		System.out.println(findSimpleGene(dna3,"ATG","TAA"));
		System.out.println(findSimpleGene(dna4,"ATG","TAA"));
	}

	public static void main(String[] args) {
		Part2 p = new Part2();
		p.testSimpleGene();

	}

}
