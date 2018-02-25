package exercise.ex4;

public enum StudentStatus {
	
	INSTATE{
		 public float getTuition(){
			return 1000;
			}
		},
	
	OUTSTATE{
		 public float getTuition(){
			return 3000;
			}
		},
	INTLSTATE{
		public float getTuition(){
			return 4000;
			}
		}
}
