export interface ITourAdminRequest {
  imageUrl: string;
  country: string;
  district: string;
  destination: string;
  introduction: string;
  description: string;
  checkIn: Date;
  checkOut: Date;
  price: number;
  promotion: boolean;
}