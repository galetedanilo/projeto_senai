export interface ITourCard {
  id: number;
  imageUri: string;
  country: string;
  district: string;
  destination: string;
  introduction: string;
  checkIn: Date;
  checkOut: Date;
  price: number;
  reviews: number;
  stars: number;
}
