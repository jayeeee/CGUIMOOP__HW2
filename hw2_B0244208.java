package jj;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
public class hw2_B0244208 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 * ID: B0244208
		 * TODO: please add student ID here    
		 * Name:蔡騏鴻
		 *  TODO: please add student name here
		 * 
		 */	
		
				Scanner sc = new Scanner(System.in);
				System.out.println("input N(deck of cards):");
				String testn= sc.nextLine(); 
		        
				int nDeck=Integer.parseInt(testn);
				Deck deck=new Deck(nDeck);
				//TODO: please check your output, make sure that you print all cards on your screen
				deck.printDeck();
				
				if(isAllCardsCorrect(deck.getAllCards(),nDeck)){
					System.out.println("Well done!");
				}else{
					System.out.println("Error, please check your sourse code");
				}
			}
			/*
			 * This method is used for checking your result, not a part of your HW2
			 */
			private static boolean isAllCardsCorrect(ArrayList<Card> allCards,int nDeck){
				//check the output 
				boolean isCorrect=true;;
				HashMap <String,Integer> checkHash=new HashMap<String,Integer>();
				for(Card card:allCards){
					int suit= card.getSuit();
					int rank = card.getRank();
					if(suit>4||suit<1||rank>13||rank<1){
						isCorrect=false;
						break;
					}
					if(checkHash.containsKey(suit+","+rank)){
						checkHash.put(suit+","+rank, 
								checkHash.get(suit+","+rank)+1);
					}else{
						checkHash.put(suit+","+rank, 1);
					}

				}
				if(checkHash.keySet().size()==52){
					for(int value:checkHash.values()){
						if(value!=nDeck){
							isCorrect=false;
							break;
						}
					}
				}else{
					isCorrect=false;
				}
				return isCorrect;
			}

		}
		/*
		 * Description: TODO: please add description here
		 */
		class Deck{
			private ArrayList<Card> cards;
			//TODO: Please implement the constructor
			public Deck(int nDeck){
				cards=new ArrayList<Card>();
				for(int deck =1;deck<=nDeck;deck++)
					{
						for(int suit=1;suit<=4;suit++)
							{
								for(int rank=1;rank<=13;rank++)
									{
										Card card= new Card(suit,rank);
										card.getSuit();		
										card.getRank();
										cards.add(card);
									}
							}
					}
				//1 Deck have 52 cards, https://en.wikipedia.org/wiki/Poker
				//Hint: Use new Card(x,y) and 3 for loops to add card into deck
				//Sample code start
				//Card card=new Card(1,1); ->means new card as clubs ace
				//cards.add(card);
				//Sample code end

			}	
			//TODO: Please implement the method to print all cards on screen
			public void printDeck(){
				//Hint: print all items in ArrayList<Card> cards, 
				//please implement and reuse printCard method in Card class
				for(Card card:cards){
					card.printCard();
				}
			}
			public ArrayList<Card> getAllCards(){
				return cards;
			}
		}
		/*
		 * Description: TODO: please add description here
		 */
		class Card{
			private int suit; //Definition: 1~4, Clubs=1, Diamonds=2, Hearts=3, Spades=4
			private int rank; //1~13
			public Card(int s,int r){
				suit=s;
				rank=r;
			}	
			//TODO: 1. Please implement the printCard method
			public void printCard(){
				//Hint: print (System.out.println) card as suit,rank, for example: print 1,1 as Clubs Ace
				//花色顯示成中文字
				String s="";
				switch(suit){
				case 1 : 
					s="梅花";
					break;
				case 2 :
					s="黑桃";
					break;
				case 3 :
					s="方塊";
					break;
				case 4 :
					s="紅心";
					if(rank==13){
						System.out.print("\n");
					}
					break;
					
				}
				if(rank%13==0){
					System.out.print("\n");
				}
				
				System.out.print(s+rank+" ");
				
			}
			public int getSuit(){
				return suit;
			}
			public int getRank(){
				return rank;
			}
	}


