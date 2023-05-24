using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Bivver
{
    public class Users
    {
        public Users(int id, string username, string nama, string password)
        {
            this.id = id;
            this.nama = nama;
            this.username = username;
            this.password = password;
            this.status = "Standby";
            this.saldo = 0;
            this.currJobs = "-";
            // myjobs = new List<Jobs>();
        }
        
        public int id { get; set; }
        public string nama { get; set; }
        public string username { get; set; }
        public string password { get; set; }
        public string status { get; set; }
        public int saldo { get; set; }
        public string currJobs { get; set; }
        // public List<Jobs> myjobs { get; set; }
    }
}
