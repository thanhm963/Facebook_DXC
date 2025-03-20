import React, { Component, useState } from 'react';

import "./NavBar.css";
import { Avatar, Grid, ListItemIcon, Menu, MenuItem, MenuList, Paper, Typography, Button } from '@mui/material';
import fblogo from "../../ImageSet/logo.png";
import searchicon from "../../ImageSet/searchicon.png";
import home from "../../ImageSet/home.svg";
import page from "../../ImageSet/pages.svg";
import watch from "../../ImageSet/watch.svg";
import market from "../../ImageSet/market.svg";
import group from "../../ImageSet/groups.svg";
import { getStorage, ref, uploadBytesResumable, getDownloadURL } from "firebase/storage";
import app from "../../firebase";
import CustomizedMenus from './CustomizedMenus';


class NavBar extends Component {
    constructor(props) {
        super(props);
    }
    state = { 
        user_image : null,
        image: null,
        anchorEl: null,
        open : true
        
    }
    handleClick = (event) => {
        this.setState({ anchorEl : event.currentTarget});
        this.setState({open : this.anchorEl});
    };
    handleClose = () => {
        this.setState({anchorEl : null});
        console.log(this.anchorEl);
    };
    render() { 
        return (  
            <div>
                <Grid className='navbar__main' container>
                    <Grid item xs = {3}>
                        <div className='navbar__leftbar'>
                            <img className='navbar__logo' src={fblogo}/>
                            <div className='navbar__search'>
                                <img className='navbar__search_icon' src={searchicon}/>
                                <input className='navbar__search_input' type='text' placeholder='Search Facebook'/>
                            </div>
                            
                        </div>
                    </Grid>
                    <Grid item xs = {6}>
                        <div className='navbar__container'>
                            <div className='navbar__tabs active'>
                                <img src={home} height='35px' width='35px'/>
                            </div>
                            <div className='navbar__tabs'>
                                <img src={page} height='35px' width='35px'/>
                            </div>
                            <div className='navbar__tabs'>
                                <img src={watch} height='35px' width='35px'/>
                            </div>
                            <div className='navbar__tabs'>
                                <img src={market} height='35px' width='35px'/>
                            </div>
                            <div className='navbar__tabs'>
                                <img src={group} height='35px' width='35px'/>
                            </div>
                        </div>
                    </Grid>
                    <Grid item xs = {3}>
                        <div className='navbar__righttab'>
                            
                            <img className='navbar__img' src='https://ik.imagekit.io/gyxs5vcin/ImageSet/6dotmenu.png?updatedAt=1693133041820'/>
                            <img className='navbar__img' src='https://ik.imagekit.io/gyxs5vcin/ImageSet/mesmenu.png?updatedAt=1693133041800'/>
                            
                            <img className='navbar__img' src='https://ik.imagekit.io/gyxs5vcin/ImageSet/noti.png?updatedAt=1693133041800'/>
                            
                            <div className='dropdown_menu' >
                                <CustomizedMenus>
                                
                                </CustomizedMenus>
                                
                            </div>
                            {/* <input style={{display:'none'}} onChange={this.updateImage} type="file" id="userImage-upload"/> */}
                        </div>
                        
                    </Grid>
                </Grid>
            </div>
        );
    }
}

 
export default NavBar;