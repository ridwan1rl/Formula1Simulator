package coursework;


abstract class Driver {


        private String drivName;
        private String NameOfDriver;
        private String Location;
        private String Team;
        private String dateGiven;





        public void setDate(String aDate) {

            dateGiven = aDate;
        }

        public String getDate() {
            return dateGiven;
        }

        public Driver() {
            drivName = "Team has not allocated a driver yet";

        }

        public void setName(String aName) {

            drivName = aName;
        }

        public String getName() {
            return drivName;
        }


        public void setNameOfDriver(String name) {
            NameOfDriver = name;
        }

        public void setLocation(String location) {
            Location = location;
        }

        public void setTeam(String team) {
            Team = team;
        }

        public void info() {
            System.out.println("\nDriver1 :" + NameOfDriver + "\nLocation:" + Location + "\nTeam:" + Team);
        }


    }

    class Formula1Driver extends Driver {


        private int driverPoints;
        private int position;
        private String race;
        private int racesAttended;


        public Formula1Driver() {

            driverPoints = 0;
            position = 0;
        }

        public Formula1Driver(String name, String location, String team, String races, int position) {
            setNameOfDriver(name);
            setLocation(location);
            setTeam(team);
            setRace(races);


            this.position = position;


        }

        public void setPosition(int Position){
            position=Position;
        }

        public int getPosition(){
            return position;
        }
        public  Formula1Driver(String Location ,int position){
            setLocation(Location);
            this.position=position;

        }



        public void driverInfo() {
            super.info();
            System.out.println("\nraces:" + race + "\nposition:" + position);

        }



        public void setDriverPoints(int position){




            if (position ==1){
                driverPoints= driverPoints+25;
            }
            else if (position==2){
                driverPoints= driverPoints+18;
            }
            else if (position==3) {
                driverPoints = driverPoints + 15;
            }
            else if (position==4){
                driverPoints= driverPoints+12;
            }
            else if (position==5) {
                driverPoints = driverPoints + 10;
            }
            else if (position==6) {
                driverPoints = driverPoints + 8;
            }
            else if (position==7) {
                driverPoints = driverPoints + 6;
            }
            else if (position==8) {
                driverPoints = driverPoints + 4;

            }
            else if (position==9) {
                driverPoints = driverPoints + 2;
            }
            else if (position==10) {
                driverPoints = driverPoints + 1;
            }
            else if (position > 10) {
                driverPoints =0;
            }


        }

        public void setRace(String rc){
            race=rc;
        }



        public String getRace(){
            return race;
        }


        public int getDriverPoints() {

            return driverPoints;
        }


    }











