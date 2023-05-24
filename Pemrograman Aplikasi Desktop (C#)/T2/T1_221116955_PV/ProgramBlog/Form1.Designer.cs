namespace ProgramBlog
{
    partial class Form1
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.LoginRegGroup = new System.Windows.Forms.GroupBox();
            this.PasswordTB = new System.Windows.Forms.TextBox();
            this.UsernameTB = new System.Windows.Forms.TextBox();
            this.RegisterBtn = new System.Windows.Forms.Button();
            this.LoginBtn = new System.Windows.Forms.Button();
            this.label2 = new System.Windows.Forms.Label();
            this.label1 = new System.Windows.Forms.Label();
            this.ContentMakerGrp = new System.Windows.Forms.GroupBox();
            this.ResetBtn = new System.Windows.Forms.Button();
            this.DeleteBtn = new System.Windows.Forms.Button();
            this.UpdateBtn = new System.Windows.Forms.Button();
            this.CreateBtn = new System.Windows.Forms.Button();
            this.ContentLikeLabel = new System.Windows.Forms.Label();
            this.ContentVisitLabel = new System.Windows.Forms.Label();
            this.SelectTitleBtn = new System.Windows.Forms.Button();
            this.richTextBox1 = new System.Windows.Forms.RichTextBox();
            this.PostDate = new System.Windows.Forms.DateTimePicker();
            this.ContentTitleTB = new System.Windows.Forms.TextBox();
            this.label6 = new System.Windows.Forms.Label();
            this.label5 = new System.Windows.Forms.Label();
            this.label4 = new System.Windows.Forms.Label();
            this.UserGroup = new System.Windows.Forms.GroupBox();
            this.ContentListBox = new System.Windows.Forms.ListBox();
            this.label3 = new System.Windows.Forms.Label();
            this.LikeLabel = new System.Windows.Forms.Label();
            this.VisitLabel = new System.Windows.Forms.Label();
            this.ContentCountLabel = new System.Windows.Forms.Label();
            this.Logout = new System.Windows.Forms.Button();
            this.HiLabel = new System.Windows.Forms.Label();
            this.menuStrip1 = new System.Windows.Forms.MenuStrip();
            this.creatorToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.browserToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.LoginRegGroup.SuspendLayout();
            this.ContentMakerGrp.SuspendLayout();
            this.UserGroup.SuspendLayout();
            this.menuStrip1.SuspendLayout();
            this.SuspendLayout();
            // 
            // LoginRegGroup
            // 
            this.LoginRegGroup.Controls.Add(this.PasswordTB);
            this.LoginRegGroup.Controls.Add(this.UsernameTB);
            this.LoginRegGroup.Controls.Add(this.RegisterBtn);
            this.LoginRegGroup.Controls.Add(this.LoginBtn);
            this.LoginRegGroup.Controls.Add(this.label2);
            this.LoginRegGroup.Controls.Add(this.label1);
            this.LoginRegGroup.Location = new System.Drawing.Point(12, 35);
            this.LoginRegGroup.Name = "LoginRegGroup";
            this.LoginRegGroup.Size = new System.Drawing.Size(253, 111);
            this.LoginRegGroup.TabIndex = 0;
            this.LoginRegGroup.TabStop = false;
            this.LoginRegGroup.Text = "Login / Register";
            // 
            // PasswordTB
            // 
            this.PasswordTB.Location = new System.Drawing.Point(73, 54);
            this.PasswordTB.Name = "PasswordTB";
            this.PasswordTB.Size = new System.Drawing.Size(174, 20);
            this.PasswordTB.TabIndex = 5;
            // 
            // UsernameTB
            // 
            this.UsernameTB.Location = new System.Drawing.Point(73, 23);
            this.UsernameTB.Name = "UsernameTB";
            this.UsernameTB.Size = new System.Drawing.Size(174, 20);
            this.UsernameTB.TabIndex = 3;
            // 
            // RegisterBtn
            // 
            this.RegisterBtn.Location = new System.Drawing.Point(137, 82);
            this.RegisterBtn.Name = "RegisterBtn";
            this.RegisterBtn.Size = new System.Drawing.Size(110, 23);
            this.RegisterBtn.TabIndex = 3;
            this.RegisterBtn.Text = "Register";
            this.RegisterBtn.UseVisualStyleBackColor = true;
            this.RegisterBtn.Click += new System.EventHandler(this.RegisterBtn_Click);
            // 
            // LoginBtn
            // 
            this.LoginBtn.Location = new System.Drawing.Point(9, 82);
            this.LoginBtn.Name = "LoginBtn";
            this.LoginBtn.Size = new System.Drawing.Size(109, 23);
            this.LoginBtn.TabIndex = 3;
            this.LoginBtn.Text = "Login";
            this.LoginBtn.UseVisualStyleBackColor = true;
            this.LoginBtn.Click += new System.EventHandler(this.LoginBtn_Click);
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(6, 57);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(59, 13);
            this.label2.TabIndex = 4;
            this.label2.Text = "Password :";
            this.label2.Click += new System.EventHandler(this.label2_Click);
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(6, 26);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(61, 13);
            this.label1.TabIndex = 3;
            this.label1.Text = "Username :";
            // 
            // ContentMakerGrp
            // 
            this.ContentMakerGrp.Controls.Add(this.ResetBtn);
            this.ContentMakerGrp.Controls.Add(this.DeleteBtn);
            this.ContentMakerGrp.Controls.Add(this.UpdateBtn);
            this.ContentMakerGrp.Controls.Add(this.CreateBtn);
            this.ContentMakerGrp.Controls.Add(this.ContentLikeLabel);
            this.ContentMakerGrp.Controls.Add(this.ContentVisitLabel);
            this.ContentMakerGrp.Controls.Add(this.SelectTitleBtn);
            this.ContentMakerGrp.Controls.Add(this.richTextBox1);
            this.ContentMakerGrp.Controls.Add(this.PostDate);
            this.ContentMakerGrp.Controls.Add(this.ContentTitleTB);
            this.ContentMakerGrp.Controls.Add(this.label6);
            this.ContentMakerGrp.Controls.Add(this.label5);
            this.ContentMakerGrp.Controls.Add(this.label4);
            this.ContentMakerGrp.Location = new System.Drawing.Point(271, 152);
            this.ContentMakerGrp.Name = "ContentMakerGrp";
            this.ContentMakerGrp.Size = new System.Drawing.Size(517, 330);
            this.ContentMakerGrp.TabIndex = 1;
            this.ContentMakerGrp.TabStop = false;
            this.ContentMakerGrp.Text = "Content Maker";
            // 
            // ResetBtn
            // 
            this.ResetBtn.Location = new System.Drawing.Point(412, 301);
            this.ResetBtn.Name = "ResetBtn";
            this.ResetBtn.Size = new System.Drawing.Size(75, 23);
            this.ResetBtn.TabIndex = 15;
            this.ResetBtn.Text = "Reset";
            this.ResetBtn.UseVisualStyleBackColor = true;
            this.ResetBtn.Click += new System.EventHandler(this.ResetBtn_Click);
            // 
            // DeleteBtn
            // 
            this.DeleteBtn.Location = new System.Drawing.Point(331, 302);
            this.DeleteBtn.Name = "DeleteBtn";
            this.DeleteBtn.Size = new System.Drawing.Size(75, 23);
            this.DeleteBtn.TabIndex = 13;
            this.DeleteBtn.Text = "Delete";
            this.DeleteBtn.UseVisualStyleBackColor = true;
            this.DeleteBtn.Click += new System.EventHandler(this.DeleteBtn_Click);
            // 
            // UpdateBtn
            // 
            this.UpdateBtn.Location = new System.Drawing.Point(412, 279);
            this.UpdateBtn.Name = "UpdateBtn";
            this.UpdateBtn.Size = new System.Drawing.Size(75, 23);
            this.UpdateBtn.TabIndex = 11;
            this.UpdateBtn.Text = "Update";
            this.UpdateBtn.UseVisualStyleBackColor = true;
            this.UpdateBtn.Click += new System.EventHandler(this.UpdateBtn_Click);
            // 
            // CreateBtn
            // 
            this.CreateBtn.Location = new System.Drawing.Point(331, 279);
            this.CreateBtn.Name = "CreateBtn";
            this.CreateBtn.Size = new System.Drawing.Size(75, 23);
            this.CreateBtn.TabIndex = 9;
            this.CreateBtn.Text = "Create";
            this.CreateBtn.UseVisualStyleBackColor = true;
            this.CreateBtn.Click += new System.EventHandler(this.CreateBtn_Click);
            // 
            // ContentLikeLabel
            // 
            this.ContentLikeLabel.AutoSize = true;
            this.ContentLikeLabel.Location = new System.Drawing.Point(54, 302);
            this.ContentLikeLabel.Name = "ContentLikeLabel";
            this.ContentLikeLabel.Size = new System.Drawing.Size(42, 13);
            this.ContentLikeLabel.TabIndex = 8;
            this.ContentLikeLabel.Text = "Like : 0";
            // 
            // ContentVisitLabel
            // 
            this.ContentVisitLabel.AutoSize = true;
            this.ContentVisitLabel.Location = new System.Drawing.Point(54, 284);
            this.ContentVisitLabel.Name = "ContentVisitLabel";
            this.ContentVisitLabel.Size = new System.Drawing.Size(41, 13);
            this.ContentVisitLabel.TabIndex = 7;
            this.ContentVisitLabel.Text = "Visit : 0";
            this.ContentVisitLabel.Click += new System.EventHandler(this.ContentVisitLabel_Click);
            // 
            // SelectTitleBtn
            // 
            this.SelectTitleBtn.Location = new System.Drawing.Point(110, 254);
            this.SelectTitleBtn.Name = "SelectTitleBtn";
            this.SelectTitleBtn.Size = new System.Drawing.Size(401, 24);
            this.SelectTitleBtn.TabIndex = 6;
            this.SelectTitleBtn.Text = "Select Title";
            this.SelectTitleBtn.UseVisualStyleBackColor = true;
            this.SelectTitleBtn.Click += new System.EventHandler(this.SelectTitleBtn_Click);
            // 
            // richTextBox1
            // 
            this.richTextBox1.Location = new System.Drawing.Point(110, 74);
            this.richTextBox1.Name = "richTextBox1";
            this.richTextBox1.Size = new System.Drawing.Size(401, 178);
            this.richTextBox1.TabIndex = 5;
            this.richTextBox1.Text = "";
            // 
            // PostDate
            // 
            this.PostDate.Location = new System.Drawing.Point(110, 45);
            this.PostDate.Name = "PostDate";
            this.PostDate.Size = new System.Drawing.Size(401, 20);
            this.PostDate.TabIndex = 4;
            // 
            // ContentTitleTB
            // 
            this.ContentTitleTB.Location = new System.Drawing.Point(110, 19);
            this.ContentTitleTB.Name = "ContentTitleTB";
            this.ContentTitleTB.Size = new System.Drawing.Size(401, 20);
            this.ContentTitleTB.TabIndex = 3;
            // 
            // label6
            // 
            this.label6.AutoSize = true;
            this.label6.Location = new System.Drawing.Point(54, 74);
            this.label6.Name = "label6";
            this.label6.Size = new System.Drawing.Size(50, 13);
            this.label6.TabIndex = 2;
            this.label6.Text = "Content :";
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Location = new System.Drawing.Point(44, 48);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(60, 13);
            this.label5.TabIndex = 1;
            this.label5.Text = "Post Date :";
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(71, 22);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(33, 13);
            this.label4.TabIndex = 0;
            this.label4.Text = "Title :";
            // 
            // UserGroup
            // 
            this.UserGroup.Controls.Add(this.ContentListBox);
            this.UserGroup.Controls.Add(this.label3);
            this.UserGroup.Controls.Add(this.LikeLabel);
            this.UserGroup.Controls.Add(this.VisitLabel);
            this.UserGroup.Controls.Add(this.ContentCountLabel);
            this.UserGroup.Controls.Add(this.Logout);
            this.UserGroup.Controls.Add(this.HiLabel);
            this.UserGroup.Location = new System.Drawing.Point(12, 152);
            this.UserGroup.Name = "UserGroup";
            this.UserGroup.Size = new System.Drawing.Size(253, 330);
            this.UserGroup.TabIndex = 1;
            this.UserGroup.TabStop = false;
            this.UserGroup.Text = "User";
            this.UserGroup.Enter += new System.EventHandler(this.groupBox3_Enter);
            // 
            // ContentListBox
            // 
            this.ContentListBox.FormattingEnabled = true;
            this.ContentListBox.Location = new System.Drawing.Point(6, 168);
            this.ContentListBox.Name = "ContentListBox";
            this.ContentListBox.Size = new System.Drawing.Size(241, 147);
            this.ContentListBox.TabIndex = 0;
            this.ContentListBox.SelectedIndexChanged += new System.EventHandler(this.ContentListBox_SelectedIndexChanged);
            this.ContentListBox.DoubleClick += new System.EventHandler(this.ContentListBox_DoubleClick);
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label3.Location = new System.Drawing.Point(7, 145);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(100, 20);
            this.label3.TabIndex = 4;
            this.label3.Text = "My Content";
            // 
            // LikeLabel
            // 
            this.LikeLabel.AutoSize = true;
            this.LikeLabel.Location = new System.Drawing.Point(76, 117);
            this.LikeLabel.Name = "LikeLabel";
            this.LikeLabel.Size = new System.Drawing.Size(42, 13);
            this.LikeLabel.TabIndex = 3;
            this.LikeLabel.Text = "Like : 0";
            this.LikeLabel.Click += new System.EventHandler(this.label3_Click);
            // 
            // VisitLabel
            // 
            this.VisitLabel.AutoSize = true;
            this.VisitLabel.Location = new System.Drawing.Point(77, 91);
            this.VisitLabel.Name = "VisitLabel";
            this.VisitLabel.Size = new System.Drawing.Size(41, 13);
            this.VisitLabel.TabIndex = 0;
            this.VisitLabel.Text = "Visit : 0";
            this.VisitLabel.Click += new System.EventHandler(this.VisitLabel_Click);
            // 
            // ContentCountLabel
            // 
            this.ContentCountLabel.AutoSize = true;
            this.ContentCountLabel.Location = new System.Drawing.Point(25, 65);
            this.ContentCountLabel.Name = "ContentCountLabel";
            this.ContentCountLabel.Size = new System.Drawing.Size(93, 13);
            this.ContentCountLabel.TabIndex = 2;
            this.ContentCountLabel.Text = "Content Count : 0 ";
            // 
            // Logout
            // 
            this.Logout.Location = new System.Drawing.Point(153, 38);
            this.Logout.Name = "Logout";
            this.Logout.Size = new System.Drawing.Size(94, 23);
            this.Logout.TabIndex = 1;
            this.Logout.Text = "LogOut";
            this.Logout.UseVisualStyleBackColor = true;
            this.Logout.Click += new System.EventHandler(this.Logout_Click);
            // 
            // HiLabel
            // 
            this.HiLabel.AutoSize = true;
            this.HiLabel.Font = new System.Drawing.Font("Microsoft PhagsPa", 11.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.HiLabel.Location = new System.Drawing.Point(6, 16);
            this.HiLabel.Name = "HiLabel";
            this.HiLabel.Size = new System.Drawing.Size(42, 20);
            this.HiLabel.TabIndex = 0;
            this.HiLabel.Text = "Hi, - ";
            // 
            // menuStrip1
            // 
            this.menuStrip1.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.creatorToolStripMenuItem,
            this.browserToolStripMenuItem});
            this.menuStrip1.Location = new System.Drawing.Point(0, 0);
            this.menuStrip1.Name = "menuStrip1";
            this.menuStrip1.Size = new System.Drawing.Size(800, 24);
            this.menuStrip1.TabIndex = 2;
            this.menuStrip1.Text = "menuStrip1";
            // 
            // creatorToolStripMenuItem
            // 
            this.creatorToolStripMenuItem.Name = "creatorToolStripMenuItem";
            this.creatorToolStripMenuItem.Size = new System.Drawing.Size(58, 20);
            this.creatorToolStripMenuItem.Text = "Creator";
            this.creatorToolStripMenuItem.Click += new System.EventHandler(this.creatorToolStripMenuItem_Click);
            // 
            // browserToolStripMenuItem
            // 
            this.browserToolStripMenuItem.Name = "browserToolStripMenuItem";
            this.browserToolStripMenuItem.Size = new System.Drawing.Size(61, 20);
            this.browserToolStripMenuItem.Text = "Browser";
            this.browserToolStripMenuItem.Click += new System.EventHandler(this.browserToolStripMenuItem_Click);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 494);
            this.Controls.Add(this.UserGroup);
            this.Controls.Add(this.ContentMakerGrp);
            this.Controls.Add(this.LoginRegGroup);
            this.Controls.Add(this.menuStrip1);
            this.MainMenuStrip = this.menuStrip1;
            this.Name = "Form1";
            this.Text = "Form1";
            this.FormClosed += new System.Windows.Forms.FormClosedEventHandler(this.Form1_FormClosed);
            this.LoginRegGroup.ResumeLayout(false);
            this.LoginRegGroup.PerformLayout();
            this.ContentMakerGrp.ResumeLayout(false);
            this.ContentMakerGrp.PerformLayout();
            this.UserGroup.ResumeLayout(false);
            this.UserGroup.PerformLayout();
            this.menuStrip1.ResumeLayout(false);
            this.menuStrip1.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.GroupBox LoginRegGroup;
        private System.Windows.Forms.GroupBox ContentMakerGrp;
        private System.Windows.Forms.GroupBox UserGroup;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.MenuStrip menuStrip1;
        private System.Windows.Forms.ToolStripMenuItem creatorToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem browserToolStripMenuItem;
        private System.Windows.Forms.Button LoginBtn;
        private System.Windows.Forms.TextBox PasswordTB;
        private System.Windows.Forms.TextBox UsernameTB;
        private System.Windows.Forms.Button RegisterBtn;
        private System.Windows.Forms.Label VisitLabel;
        private System.Windows.Forms.Label ContentCountLabel;
        private System.Windows.Forms.Button Logout;
        private System.Windows.Forms.Label HiLabel;
        private System.Windows.Forms.Label LikeLabel;
        private System.Windows.Forms.ListBox ContentListBox;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Button ResetBtn;
        private System.Windows.Forms.Button DeleteBtn;
        private System.Windows.Forms.Button UpdateBtn;
        private System.Windows.Forms.Button CreateBtn;
        private System.Windows.Forms.Label ContentLikeLabel;
        private System.Windows.Forms.Label ContentVisitLabel;
        private System.Windows.Forms.Button SelectTitleBtn;
        private System.Windows.Forms.RichTextBox richTextBox1;
        private System.Windows.Forms.DateTimePicker PostDate;
        private System.Windows.Forms.TextBox ContentTitleTB;
        private System.Windows.Forms.Label label6;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.Label label4;
    }
}

