
  abstract   class Personal extends Employee implements WorkTime{

        Personal(long id, String name, long workTime, int base,int payment){
            super(id,name,workTime,base,payment);

        }
        public double payForHours() {
            return 0;
        }




    }

  class Cleaner extends Personal {
      Cleaner(long id, String name, long workTime, int base,int payment){
          super(id,name,workTime,base,payment);
      }

      public double calcPayment() {
          return payForHours();
      }

      public double payForHours() {
          if(getWorkTime()>100) {
              return getWorkTime() * getBase() * 1.3;
          } else
          return getWorkTime()*getBase();
      }
  }

  class Driver extends Personal {
    Driver(long id, String name, long workTime, int base, int payment){
        super(id,name,workTime,base,payment);
    }

      public double calcPayment() {
          return payForHours();
      }

      public double payForHours() {
        if(getWorkTime()>150){
            return getWorkTime()*getBase()*1.5;
        }else
          return getWorkTime()*getBase();
      }

  }