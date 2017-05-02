export class Task {

    constructor(public id:number, public title:string, public created:Date = new Date(), public planned:Date){ }
}