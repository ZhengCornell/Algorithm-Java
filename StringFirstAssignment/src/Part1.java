
public class Part1 {
	public String findSimpleGene(String dna){
		int startIndex = dna.indexOf("ATG");
		
		if(startIndex == -1){
			return "gg";
		}
		int stopIndex = dna.indexOf("TAA");
		if(stopIndex == -1){
			return "gg2";
		}
		if ((startIndex - stopIndex) % 3 == 0){
			return dna.substring(startIndex,stopIndex+3);
		}
		return null;
	}
	public void testSimpleGene(){
		String dna = "AAATGCCCTAACTAGATTAAGAAACC";
		String dna2 = "BDETGTAA";
		String dna3 = "BDEATGTA";
		String dna4 = "BEDATGATAA";
		System.out.println(findSimpleGene(dna));
		System.out.println(findSimpleGene(dna2));
		System.out.println(findSimpleGene(dna3));
		System.out.println(findSimpleGene(dna4));
	}
	public static void main(String[] args){
		Part1 p = new Part1();
		p.testSimpleGene();
	}
}
