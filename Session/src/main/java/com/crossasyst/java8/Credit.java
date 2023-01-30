package com.crossasyst.java8;


public class Credit
    {

        public static String getCreditCardType(String card)
        {
            if(card!= null)
            {

                if (card.startsWith("4"))
                {
                    return "Visa";
                }
                else if (card.startsWith("31"))
                {
                    return "Master";
                }
                else if (card.startsWith("3"))
                {
                    return "Diner"
                }
                else
                {
                    return "other";
                }

            }
        }

        public static void main(String[] args) {

            Credit.getCreditCardType("400132");

        }

    }
