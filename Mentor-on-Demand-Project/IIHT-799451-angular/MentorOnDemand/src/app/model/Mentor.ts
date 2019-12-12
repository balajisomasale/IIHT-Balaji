import { User } from './User';

export interface Mentor
{
         id?: number,
         linkedinURL: String,
        yearsOfExperience: number,
        timeslot: String,

        user: User
}