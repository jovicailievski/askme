import { IQuestion } from './question';
import { IUser } from './user';
import { IVote } from './vote';

export interface IAnswer{
    id: number,
    description: string,
    question: IQuestion,
    user:IUser,
    votes: Array<IVote>
    
}