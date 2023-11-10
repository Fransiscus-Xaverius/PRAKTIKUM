import { useState } from 'react'
import './App.css'
import Joi from "joi"
import { useForm } from 'react-hook-form'
import { joiResolver } from '@hookform/resolvers/joi'
import AboutMe from './AboutMe'
import Education from './Education'
import Experiences from './Experiences'
import EduItem from './EduItem'
import ExpItem from './ExpItem'
import './index.css'

function App() {
  const [experience, setExperience] = useState([
    {
      title:"",
      place:"",
      description:"",
      start:"",
      end:""
    }
  ]);

  const [mode, setMode] = useState(0);

  const [highschool, setHighschool] = useState({
    required:false,
    place:"",
    start:"",
    end:""
  })
  const [diploma, setDiploma] = useState({
    required:false,
    place:"",
    start:"",
    end:""
  })
  const [bachelor, setBachelor] = useState({
    required:false,
    place:"",
    start:"",
    end:""
  })
  const [master, setMaster] = useState({
    required:false,
    place:"",
    start:"",
    end:""
  })

  const handleHighschool = (temp) => {
    setHighschool(temp);
    console.log(temp);
  }

  const handleDiploma = (temp) => {
    setDiploma(temp);
  }

  const handleBachelor = (temp) => {
    setBachelor(temp);
  }

  const handleMaster = (temp) => {
    setMaster(temp);
  }

  const addExperience = () => {
    setExperience([
      ...experience,
      {
        title:"",
        place:"",
        description:"",
        start:"",
        end:""
      }
    ])
  }

  const removeExperience = (index) => {
    let temp = experience;
    temp.splice(index, 1);
    setExperience(temp);
  }

  const schema = Joi.object({
    name: Joi.string().required().messages({
        "string.empty": "Name must not be empty",
        "any.required": "Name is required"
    }),
    title: Joi.string().required().messages({
        "string.empty": "Title must not be empty",
        "any.required": "Title is required"
    }),
    phone: Joi.string().required().messages({
        "string.empty": "Phone Number must not be empty",
        "any.required": "Phone Number is required"
    }),
    email: Joi.string().required().messages({
        "string.empty": "Email must not be empty",
        "any.required": "Email is required"
    }),
    domicile: Joi.string().required().messages({
        "string.empty": "Domicile must not be empty",
        "any.required": "Domicile is required"
    }),
    linkedin: Joi.string().required().messages({
        "string.empty": "Linkedin ID must not be empty",
        "any.required": "Linkedin ID is required"
    }),
    photo: Joi.string().required().messages({  
        "string.empty": "Photo URL must not be empty",
        "any.required": "Photo URL is required"
    }),
    aboutme: Joi.string().required().max(100).messages({
      "string.empty": "About Me must not be empty",
      "any.required": "About Me is required",
      "string.max": "About Me must not be more than 100 characters"
    }),
    exp: Joi.object().keys({
      title: Joi.string().required().messages({
        "string.empty": "Title must not be empty",
        "any.required": "Title is required"
      }),
      place: Joi.string().required().messages({
        "string.empty": "Place must not be empty",
        "any.required": "Place is required"
      }),
      description: Joi.string().required().messages({
        "string.empty": "Description must not be empty",
        "any.required": "Description is required"
      }),
      start: Joi.string().required().messages({
        "string.empty": "Start must not be empty",
        "any.required": "Start is required"
      }),
      end: Joi.string().required().messages({
        "string.empty": "End must not be empty",
        "any.required": "End is required"
      })
    })
  })

  const { register, handleSubmit, reset, formState: { errors } } = useForm({
    resolver: joiResolver(schema)
  })

  const changeExp = (index, title, place, description, start, end) => {
    let temp = experience;
    temp[index].title = title;
    temp[index].place = place;
    temp[index].description = description;
    temp[index].start = start;
    temp[index].end = end;
    setExperience(temp);
    console.log(temp[0]);
    register.exp = temp;
  }

  const [endData, setEndData] = useState({
    name:"",
    title:"",
    phone:"",
    email:"",
    domicile:"",
    linkedin:"",
    photo:"",
    aboutme:"",
  })

  const changeName = (e) => {
    let temp = endData;
    temp.name = e.target.value;
    setEndData(temp);
  }

  const changeTitle = (e) => {
    let temp = endData;
    temp.title = e.target.value;
    setEndData(temp);
  }

  const changePhone = (e) => {
    let temp = endData;
    temp.phone = e.target.value;
    setEndData(temp);
    console.log(temp);
  }

  const changeEmail = (e) => {
    let temp = endData;
    temp.email = e.target.value;
    setEndData(temp);
  }

  const changeDomicile = (e) => {
    let temp = endData;
    temp.domicile = e.target.value;
    setEndData(temp);
  }

  const changeLinkedin = (e) => {
    let temp = endData;
    temp.linkedin = e.target.value;
    setEndData(temp);
  }

  const changePhoto = (e) => {
    let temp = endData;
    temp.photo = e.target.value;
    setEndData(temp);
  }

  const changeAboutme = (data) => {
    let temp = endData;
    temp.aboutme = data;
    setEndData(temp);
    console.log(temp);
  }

  const submitData = (data) => {
    setMode(1);
  }

  const printpage = () => {
    window.print();
  }
  
  if(mode==0){
    return (
      <>
        <div className="container-fluid bg-secondary">
          <form action="" onSubmit={handleSubmit(submitData)}>
            <div className="row">
              <div className="col-3 container-flex justify-content-center">
                <button className=" btn btn-danger">Clear</button>
              </div>
              <div className="col-6">
                <h2 className="text-white p-3 text-center">CV MAKER</h2>
              </div>
            </div>
            <div className="row p-1">
            <div className="container-fluid bg-white p-5 rounded" style={{width:"60%"}}>
              <div className="row justify-content-center">
                  <div className="col-5 m-2 container-fluid">
                      <div className="row justify-content-center">
                          <input type="text" name="" id="" placeholder="Nama" {...register("name")} onChange={changeName}/>
                          {errors.name && <span style={{color:"red"}}>{errors.name.message} <br /></span>}
                      </div>
                  </div>
                  <div className="col-5 m-2">
                  <div className="row">
                          <input type="text" name="" id="" placeholder="Title" {...register("title")} onChange={changeTitle}/>
                          {errors.title && <span style={{color:"red"}}>{errors.title.message} <br /></span>}
                      </div>
                  </div>
              </div>
              <div className="row justify-content-center">
                  <div className="col-5 m-2 container-fluid">
                      <div className="row justify-content-center">
                          <input type="text" name="" id="" placeholder="Phone Number" {...register("phone")} onChange={changePhone}/>
                          {errors.phone && <span style={{color:"red"}}>{errors.phone.message} <br /></span>}
                      </div>
                  </div>
                  <div className="col-5 m-2">
                  <div className="row">
                          <input type="text" name="" id="" placeholder="Email" {...register("email")} onChange={changeEmail}/>
                          {errors.email && <span style={{color:"red"}}>{errors.email.message} <br /></span>}
                      </div>
                  </div>
              </div>
              <div className="row justify-content-center">
                  <div className="col-5 m-2 container-fluid">
                      <div className="row justify-content-center">
                          <input type="text" name="" id="" placeholder="Domicile" {...register("domicile")} onChange={changeDomicile}/>
                          {errors.name && <span style={{color:"red"}}>{errors.domicile.message} <br /></span>}
                      </div>
                  </div>
                  <div className="col-5 m-2">
                  <div className="row">
                          <input type="text" name="" id="" placeholder="Linkedin ID" {...register("linkedin")} onChange={changeLinkedin}/>
                          {errors.linkedin && <span style={{color:"red"}}>{errors.linkedin.message} <br /></span>}
                      </div>
                  </div>
              </div>
              <div className="row justify-content-center ">
                  <input type="text" name="" id="" placeholder="Photo URL" {...register("photo")} onChange={changePhoto}/>
                  {errors.photo && <span style={{color:"red"}}>{errors.photo.message} <br /></span>}
              </div>
          </div>
            </div>
            <div className="row p-1">
              <AboutMe register={register} errors={errors} changeAboutme={changeAboutme}/>
            </div>
            <div className="row p-1">
              <Education setHighschool={handleHighschool} setDiploma={handleDiploma} setBachelor={handleBachelor} setMaster={handleMaster} register={register} errors={errors}/>
            </div>
            <div className="row p-1">
              <Experiences experience={experience} addExperience={addExperience} removeExperience={removeExperience} changeExp={changeExp} register={register} errors={errors}/>
            </div>
            <div className="row p-1">
              <div className="container-fluid d-flex align-items-center justify-content-center"> 
                <button type="submit">Generate</button>
              </div>
            </div>
          </form>
        </div>
      </>
    )
  }
  else{
    return (
      <>
        <div className="container-fluid bg-secondary" style={{minHeight:"1080px"}}>
          <div className="row" id="head">
            <div className="col-2 container">
              <button className="btn btn-danger">Back</button>
            </div>
            <div className="col-6 container">
              <h2 className="text-white p-3 text-center">CV MAKER</h2>
            </div>
            <div className="col-2 container">
              <button className="btn btn-primary" onClick={printpage}>Print</button>
            </div>
          </div>
          <div className="row">
            <div className="container-fluid bg-white rounded" style={{width:"60%", height:"100%"}}>
              <div className="row">
                <div className="col-4 container-fluid justify-item-center align-items-center p-5">
                  <img src={endData.photo} style={{width:"200px", height:"200px"}} alt="" />
                </div>
                <div className="col-6 container-fluid justify-item-center align-items-center text-center p-5">
                  <h1>{endData.name}</h1> <h2>{endData.title}</h2>
                  <hr />
                  <div className="container">
                    <div className="row">
                    <div className="col-5 container">
                    <h6>{endData.phone}</h6>
                    <br />
                    <h6>{endData.linkedin}</h6>
                  </div>
                  <div className="col-5 container">
                    <h6>{endData.email}</h6>
                    <br />
                    <h6>{endData.domicile}</h6>
                  </div>
                    </div>
                  </div>
                </div>
              </div>
              <hr />
              <div className="container-fluid justify-content-center">
                <div className="col container-fluid align-items-center">
                  <div className="row container-fluid d-flex justify-content center">
                    <h1>About Me</h1>
                  </div>
                  <div className="row">
                    <p>{endData.aboutme}</p>
                  </div>
                </div>
              </div>
              <hr />
              <div className="container-fluid d-flex justify-content-center">
                <div className="col-4 border-right p-5" >
                  <div className="row">
                    <div className="container rounded bg-primary">
                      <h4 className='text-white text-center'>Education</h4>
                    </div>
                  </div>
                  <div className="row">
                    {
                      highschool.required && <EduItem tingkat={"High School"} name={highschool.place} start={highschool.start} end={highschool.end}/>
                    }
                    {
                      diploma.required && <EduItem tingkat={"Diploma"} name={diploma.place} start={diploma.start} end={diploma.end}/>
                    }
                    {
                      bachelor.required && <EduItem tingkat={"Bachelor"} name={bachelor.place} start={bachelor.start} end={bachelor.end}/>
                    }
                    {
                      master.required && <EduItem tingkat={"Master"} name={master.place} start={master.start} end={master.end}/>
                    }
                  </div>
                </div>
                <div className="col-4 p-5">
                  <div className="row">
                    <div className="container rounded bg-success">
                      <h4 className='text-white text-center'>Experience</h4>
                    </div>
                  </div>
                  <div className="row">
                    {
                      experience.map((item,index) =>{
                        if(item.title.length>0&&item.description.length>0&&item.place.length>0&&item.start.length>0&&item.end.length>0){
                          return (
                            <ExpItem item={item} key={index}/>
                          )
                        }
                      })
                    }
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </>
    )
  }
}

export default App
