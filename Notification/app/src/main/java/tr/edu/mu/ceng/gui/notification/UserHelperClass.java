package tr.edu.mu.ceng.gui.notification;

public class UserHelperClass {
        String city, Bölge_no, sıcaklık, rüzgar;

        public UserHelperClass() {
        }
        public UserHelperClass(String city, String Bölge_no, String sıcaklık, String rüzgar) {
            this.city = city;
            this.Bölge_no = Bölge_no;
            this.sıcaklık = sıcaklık;
            this.rüzgar = rüzgar;

        }

        public String getName() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String Bölge_no() {
            return Bölge_no;
        }

        public void setBölge_no(String Bölge_no) {
            this.Bölge_no = Bölge_no;
        }

        public String getSıcaklık() {
            return sıcaklık;
        }

        public void setSıcaklık(String sıcaklık) {
            this.sıcaklık = sıcaklık;
        }

        public String getRüzgar() {
            return rüzgar;
        }

        public void setRüzgar(String rüzgar) {
            this.rüzgar = rüzgar;
        }



}
