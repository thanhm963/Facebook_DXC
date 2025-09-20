// firebaseAuth.js
import  { app } from "./firebase"; // Import default, không bị vòng lặp
import { getAuth } from "firebase/auth";

const auth = getAuth(app);
export default auth;
