import React, { Component } from 'react';
import "./LoginHome.css";
import { Alert, Grid } from '@mui/material';
import { Avatar, Paper } from '@mui/material';
import { getAuth, createUserWithEmailAndPassword, signInWithEmailAndPassword, reload} from "firebase/auth";
import app from "../../firebase";
import facebooksignup from "../../images/images/facebooksignup";
import Post from '../MainPage/PostContainer/Post';




class LoginHome extends Component {
    constructor(props) {
        super(props);
        this.state = { 
            signIN : true,

            // sign up
            signup_name : null,
            signup_email : null, 
            signup_password : null,

            // sign in

            signin_email: null,
            signin_password: null
        }
    }   
    switchPanel=()=>{
        if(this.state.signIN)
            this.setState({signIN : false});
        else
            this.setState({signIN : true});
    }
    signUP=()=>{
        const auth = getAuth(app);
        createUserWithEmailAndPassword(auth, this.state.signup_email, this.state.signup_password)
        .then((userCredential) => {
            // Signed up
            const user = userCredential.user;
            
            let payload = {
                "userID" : user.uid,
                "userName" : this.state.signup_name,
                "userImage" : ""
            }
            const requestOptions = {
                method: "POST",
                headers: {'Content-Type': 'application/json'},
                body: JSON.stringify(payload),
            }
            fetch("http://facebookaws-1465022890.ap-southeast-1.elb.amazonaws.com/api/userService/save", requestOptions)
            .then(respone => respone.json())
            .then(data => {
                localStorage.setItem("user",JSON.stringify(data));
                window.location.reload();
                
            })
            .catch(error=>{
                
            })
        })
        .catch((error) => {
        const errorCode = error.code;
        const errorMessage = error.message;
        alert(errorCode);
        // ..
        })
    }
    signIN=()=>{
        const auth = getAuth(app);
        signInWithEmailAndPassword(auth, this.state.signin_email, this.state.signin_password)
        .then((userCredential) => {
        // Signed in 
        const user = userCredential.user;
        fetch("http://facebookaws-1465022890.ap-southeast-1.elb.amazonaws.com/api/userService/getUserDetails/"+ user.uid)
            .then(respone => respone.json())
            .then(data => {
                localStorage.setItem("user",JSON.stringify(data));
                window.location.reload();
            })
            .catch(error=>{
            })
    })
    .catch((error) => {
        const errorCode = error.code;
        const errorMessage = error.message;
        alert(errorCode);
    });
    }
    render() { 
        return ( 
        <div className="main__container">
            <Grid className="main__content" container >
                    <Grid item xs={7}>
                        <div className="fblogo">
                            <img src={facebooksignup} width="300px" />
                        </div>
                        <div> 
                            <h1 className="text">Facebook helps you connect and share with the people in your life.</h1>
                        </div>
                    </Grid>
                    <Grid item xs={3}>
                        <Paper className="logincard__container">
                        {
                            this.state.signIN == true ?
                        
                            <div container="login__panel" >
                                <div>
                                    <input onChange={(event)=>{this.state.signin_email=event.currentTarget.value}} type="text" className="login__input" placeholder="Email address" />
                                </div>
                                <div>
                                    <input onChange={(event)=>{this.state.signin_password=event.currentTarget.value}} type="password" className="login__input" placeholder="Password"/>
                                </div>
                                <div>
                                    <button onClick={this.signIN} className="login__button">Log in</button>
                                </div>
                                <div>
                                    <div className="forget_Text">Forgotten password?</div>
                                </div>
                                <div>
                                    <div className="dividor"></div>
                                </div>
                                <div>
                                    <button onClick = {this.switchPanel} className="login__createnew">Create New Account</button>
                                </div>
                            </div>
                            :
                            <div container="login__panel">
                                <div>
                                    <input onChange={(event)=>{this.state.signup_name=event.currentTarget.value}} type="text" className="login__input" placeholder="Name" />
                                </div>
                                <div>
                                    <input onChange={(event)=>{this.state.signup_email=event.currentTarget.value}} type="text" className="login__input" placeholder="Email address" />
                                </div>
                                <div>
                                    <input onChange={(event)=>{this.state.signup_password=event.currentTarget.value}} type="password" className="login__input" placeholder="Password"/>
                                </div>
                                <div>
                                    <button onClick={this.signUP} className="login__button">Sign Up</button>
                                </div>
                                <div>
                                    <div onClick = {this.switchPanel} className="forget_Text">Already have account?</div>
                                </div>
                            </div>
                         }

                        </Paper>
                    </Grid>
                    <Grid item xs={1}></Grid>
            </Grid>
        </div> );
    }
}
 
export default LoginHome;