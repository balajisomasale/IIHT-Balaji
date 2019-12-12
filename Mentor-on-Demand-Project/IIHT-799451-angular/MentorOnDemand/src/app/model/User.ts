export interface User
{
    id: number,
    userName: String,
    password: String,
    firstName: String,
    lastName: String,
    contactNumber: number,
    regCode?: String,
    role: String,
    // linkedinUrl: String,
    // yearsOfExperience:number,
    // active?: Boolean,
    // confirmedSignup?: Boolean,
    resetPassword?: Boolean,
    resetPasswordDate?: Date 
}