using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ProgramBlog
{
    public class Content
    {
        private string title;
        private string uploader;
        private string isi;
        private int view;
        private DateTime postdate;
        private List<string> listLike;

        public void UserLiked(string u)
        {
            listLike.Add(u);
        }

        public void unLike(string u)
        {
            listLike.Remove(u);
        }

        public bool isLiked(string u)
        {
            if (listLike.Contains(u))
            {
                return true;
            }
            return false;
        }

        public Content(string title, string uploader, string isi, DateTime postdate)
        {
            this.title = title;
            this.uploader = uploader;
            listLike = new List<string>();
            this.isi = isi;
            this.postdate = postdate;
            this.view = 0;
        }

        public string Title
        {
            get { return title; }
            set { title = value; }
        }

        public string Isi
        {
            get { return isi; }
            set { isi = value; }
        }

        public string Uploader
        {
            get { return uploader; }
            set { uploader = value; }
        }

        public DateTime postDate
        {
            get { return postdate; }
            set { postdate = value; }
        }
        public int View
        {
            get { return view; }
            set { view = value; }
        }
        public int Like
        {
            get { return listLike.Count; }
        }

    }
}
