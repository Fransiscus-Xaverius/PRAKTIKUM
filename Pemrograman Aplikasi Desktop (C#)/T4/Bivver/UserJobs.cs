using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Bivver
{
    public class UserJobs
    {
        public UserJobs(string applicant, string category, string description, int harga, string status)
        {
            this.applicant = applicant;
            this.category = category;
            this.description = description;
            this.harga = harga;
            this.status = "Menunggu";
        }

        public string status { get; set; }
        public string applicant { get; set; }
        public string category { get; set; }
        public string description { get; set; }
        public int harga { get; set; }
    }
}
