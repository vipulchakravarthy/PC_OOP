

class Card{
	//
	String faceValue;
	//
	String suitValue;

	Card(){
	}

	Card(String fv, String sv){
		this.faceValue = fv;
		this.suitValue = sv;
	}

	//setter for face value

	public void setFaceValue(String fv){
		this.faceValue = fv;
	}

	//setter for suit value

	public void setSuitValue(String sv){
		this.suitValue = sv;
	}

	//getter for face value
	public String getFaceValue(){
		return this.faceValue;
	}

	public String getSuitValue(){
		return this.suitValue;
	}

	public String toString(){
		return this.suitValue +" : "+this.faceValue;
	}
}



public class Solution{

	public static void main(String[] args) {
		Card[] deck = new Card[52];

		String[] suits = {"Spade", "Club", "Diamond", "Heart"};
		String[] face = {"2","3","4","5","6","7","8","9","T", "J","Q","K","A"};
		int position = 0;
		for(int i = 0; i < suits.length; i++){
			for(int j = 0; j < face.length;j++){
				Card card = new Card();
				card.setSuitValue(suits[i]);
				card.setFaceValue(face[j]);
				deck[position++] = card;
			}
		}

		System.out.println("****Your deck****");
		for(int i = 0; i < deck.length;i++){
			System.out.println(deck[i]);
		}
	}
}
