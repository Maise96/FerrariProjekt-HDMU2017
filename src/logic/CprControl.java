package logic;

class CprControl {
	boolean result;
		CprControl(String cpr){
			try{
			if(cpr.length()==10 && legitDate(cpr) && isNumbers(cpr)){
				result = true;
			}
			else result = false;
			}
			catch(NumberFormatException e){
				result = false;
			}
		}
		private boolean legitDate(String cpr)throws NumberFormatException{
			int dag = Integer.parseInt(cpr.substring(0,2));
			int måned = Integer.parseInt(cpr.substring(2,4));
			int år = Integer.parseInt(cpr.substring(4,6));
			return dag >=1  && dag <= 31 && måned>= 1 && måned <= 12 && år >=0 && år<=99;
		}
		boolean getResult(){
			return result;
		}
		public boolean isNumbers(String text){
			for (int i = 0; i < text.length(); i++) {
				String checkLetter = text.substring(i, i + 1);
				if (!isNumber(checkLetter)) {
					return false;
				}
			}
			return true;
		}
		private boolean isNumber(String s){
			return "1234567890".contains(s);
		}
}
