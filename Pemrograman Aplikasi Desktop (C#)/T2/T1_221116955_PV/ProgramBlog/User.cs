using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ProgramBlog
{
    public class User
    {
        private string username;
        private string password;
        private List<Content> listcontent;
        private int view;
        private int like;
        

        public User(string username, string password)
        {
            this.username = username;
            this.password = password;
            listcontent = new List<Content>();
            this.like = 0;
            
            this.view = 0;
        }

        public int Like
        {
            get { return like; }
            set { like = value; }
        }

        public int View
        {
            get { return view; }
            set { view = value; }
        }

        public List<Content> getContent()
        {
            return this.listcontent;
        }
        public string getUsername()
        {
            return this.username;
        }

        public string getPassword()
        {
            return this.password;
        }

        public void setUsername(string s)
        {
            this.username = s;
        }

        public void setPassword(string s)
        {
            this.password = s;
        }

        public void addContent(Content newContent)
        {
            listcontent.Add(newContent);
        }

    }
}
