import React, { Component } from 'react'
import './UploadSection.css';
import { Avatar, Dialog, Paper } from '@mui/material';
import live from "../../../ImageSet/video.png";
import image from "../../../ImageSet/image.png";
import feelings from "../../../ImageSet/feelings.png";
import { getStorage, ref, uploadBytesResumable, getDownloadURL } from "firebase/storage";
import app from "../../../firebase";


class UploadSection extends Component {
    constructor(props) {
        super(props);
    }
    state = { 
        open : false,
        uploadImage : null,
        description : ""
    }
    handleClose=()=>{
        this.setState({open : false});
    }
    openDialog=(event)=>{
        this.setState({open : true});
        this.setState({uploadImage : URL.createObjectURL(event.target.files[0])});
        this.setState({image: event.target.files[0]});
    }
    uploadToFireBase=(event)=>{
        const thisContext = this;
        if(image==undefined || image==null){
            return;
        }
        const storage = getStorage(app);
        const storageRef = ref(storage, 'images/' + this.state.image.name);

        const uploadTask = uploadBytesResumable(storageRef,this.state.image);
        uploadTask.on('state_changed', 
        (snapshot) => {
            const progress = (snapshot.bytesTransferred / snapshot.totalBytes) * 100;
            console.log('Upload is ' + progress + '% done');
            switch (snapshot.state) {
            case 'paused':
                console.log('Upload is paused');
                break;
            case 'running':
                console.log('Upload is running');
                break;
            }
            
        }, 
        (error) => {
            // Handle unsuccessful uploads
        }, 
        () => { 
                // Handle successful uploads on complete
                // For instance, get the download URL: https://firebasestorage.googleapis.com/...
                getDownloadURL(uploadTask.snapshot.ref).then((downloadURL) => {
                console.log('File available at', downloadURL);
                let payload = {
                    "userID" : JSON.parse(localStorage.getItem("user")).userID,
                    "imageURL" : JSON.parse(localStorage.getItem("user")).userImage,
                    "userName" : JSON.parse(localStorage.getItem("user")).userName,
                    "description": thisContext.state.description,
                    "postImgURL" : downloadURL
                }
                const requestOptions = {
                    method: "POST",
                    headers: {'Content-Type': 'application/json'},
                    body: JSON.stringify(payload),
                }
                fetch("http://facebookaws-1465022890.ap-southeast-1.elb.amazonaws.com/api/postService/save", requestOptions)
                .then(respone => respone.json())
                .then(data => {
                    console.log(data);
                    thisContext.setState({open : false});
                    thisContext.props.update();
                })
                .catch(error =>{

                })
            });
        }
        ); 
         
    }

    render() { 
        return ( 
            <div>
                <Dialog className='upload__dialog' onClose={this.handleClose} open={this.state.open}>
                    <div className='upload__header'>Create Post</div>
                    <input onChange={(event)=>this.state.description=event.currentTarget.value} type='text' className="upload__textbox" placeholder="what's on your mind"/>
                    <img src={this.state.uploadImage} className='upload__preview'/>
                    <input style={{cursor:"pointer"}} className='upload__button2' type='button' value='Post' onClick={this.uploadToFireBase} />
                </Dialog>
                <Paper className='upload__container'>
                    <div className='upload_top'>
                        <div>
                            <Avatar src={JSON.parse(localStorage.getItem("user")).userImage} className='upload_img'/>
                        </div>
                        <div>
                            <input className='upload_box' placeholder="what's on your mind" type='text'/>
                        </div>
                    </div>
                    <div className='upload__border'/>
                    <div className='upload__bottom'>   
                        <div className='upload__tabs'>
                            <img src={live} width='35px'/>
                            <div className='upload__text'>Live Video</div>
                        </div>
                        <div className='upload__tabs'>
                            <label style={{cursor:"pointer"}} for="file-upload" className='upload__tabs'>
                                <img src={image} width='35px'/>
                                <div className='upload__text'>Photo/Video</div>
                            </label>
                            <input type="file" id="file-upload" onChange={this.openDialog} />
                        </div>
                        <div className='upload__tabs'>
                            <img src={feelings} width='35px'/>
                            <div className='upload__text'>Feeling/Activity</div>
                        </div>
                    </div>
                </Paper>
            </div>
         );
    }
}
 
export default UploadSection;