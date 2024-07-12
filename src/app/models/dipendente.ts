import { Giornaliera } from "./giornaliera";

export class Dipendente {
    nome?: string;
    cognome?: string;
    codIdentificativo?: string;
    username?: string;
    password?: string;
    
    giornaliere?: Giornaliera[];

}
